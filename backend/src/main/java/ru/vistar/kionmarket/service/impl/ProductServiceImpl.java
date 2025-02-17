package ru.vistar.kionmarket.service.impl;

import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.ProductRequestDto;
import ru.vistar.kionmarket.dto.ProductResponseDto;
import ru.vistar.kionmarket.mapper.ProductMapper;
import ru.vistar.kionmarket.mapper.impl.ProductMapperImpl;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.repository.ShopRepository;
import ru.vistar.kionmarket.repository.SubcategoryRepository;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.service.ProductService;
import ru.vistar.kionmarket.util.FileStorageUtil;
import ru.vistar.kionmarket.exception.ResourceAlreadyExistsException;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final ProductMapper productMapper;
    private final UserRepository userRepository;
    private final FileStorageUtil fileStorageUtil;


    private final String IMAGE_DIRECTORY = "src/main/resources/images/";
    private final String IMAGE_NAME_PREFIX = "product_";
    private final int MAX_IMAGES = 10;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SubcategoryRepository subcategoryRepository,UserRepository userRepository, FileStorageUtil fileStorageUtil, ProductMapperImpl productMapper) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.userRepository = userRepository;
        this.fileStorageUtil = fileStorageUtil;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {

        String name = productRequestDto.getName();
        String description = productRequestDto.getDescription();
        Subcategory subcategory = subcategoryRepository.findById(productRequestDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productRequestDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productRequestDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productRequestDto.getShopId())));
        Product product = new Product(name,description,subcategory,shop);

        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void uploadProductImages(Long productId, MultipartFile[] images){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));

        int imageIndex = 0;
        for(int i = 0; i < MAX_IMAGES; ++i){
            String fileName = IMAGE_NAME_PREFIX + productId + "_" + i;
            if(!fileStorageUtil.isFileExist(IMAGE_DIRECTORY, fileName)){
                fileStorageUtil.saveFile(images[imageIndex], IMAGE_DIRECTORY, fileName);
                ++imageIndex;
            }
            if(i == MAX_IMAGES - 1)
                throw new ResourceAlreadyExistsException("TODO: Too many images");
        }
        productRepository.save(product);
    }

    @Override
    public List<byte[]> getProductImages(Long productId){
        List<byte[]> images = new ArrayList<>();

        for(int i = 0; i < MAX_IMAGES; ++i){
            String fileName = IMAGE_NAME_PREFIX + productId + "_" + i;
            if(fileStorageUtil.isFileExist(IMAGE_DIRECTORY,fileName)){
                byte[] image = fileStorageUtil.findFile(IMAGE_DIRECTORY, fileName);
                images.add(image);
            }
            else
                break;
        }

        return images;
    }

    @Override
    public ProductResponseDto update(Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        Subcategory subcategory = subcategoryRepository.findById(productRequestDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productRequestDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productRequestDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productRequestDto.getShopId())));
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setSubcategory(subcategory);
        product.setShop(shop);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductResponseDto findById(Long productId) {
        return productMapper.toDto(productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId))));
    }

    @Override
    public Page<ProductResponseDto> findAll(
            Integer page,
            Integer limit,
            String sort,
            String order,
            @Nullable Long categoryFilter,
            @Nullable Long subcategoryFilter,
            @Nullable Integer priceFrom,
            @Nullable Integer priceTo,
            @Nullable Long shopFilter,
            @Nullable String search,
            @Nullable Boolean isFavorite) {

        Sort.Direction direction = order.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, limit, direction, sort);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = Long.parseLong(userDetails.getUsername());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %1$s not found", userId)));


        Specification<Product> spec = Specification.where(null);
        if (categoryFilter != null)
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("subcategory").get("category").get("id"), categoryFilter));
        if (subcategoryFilter != null)
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("subcategory").get("id"), subcategoryFilter));
        if (priceFrom != null)
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("price").get("price"), priceFrom));
        if (priceTo != null)
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("price").get("price"), priceTo));
        if (shopFilter != null)
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("shop").get("id"), shopFilter));
        if (search != null && !search.isEmpty()) {
            String searchLowerCase = search.toLowerCase();
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchLowerCase + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + searchLowerCase + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("subcategory").get("name")), "%" + searchLowerCase + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("subcategory").get("category").get("name")), "%" + searchLowerCase + "%")
                    ));
        }
        if(isFavorite != null && isFavorite){
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.isMember(user, root.get("usersAddedToFavorites")));
        }

        return productRepository.findAll(spec, pageable).map(new Function<Product,ProductResponseDto>(){
            @Override
            public ProductResponseDto apply(Product product){
                return productMapper.toDto(product);
            }
        });
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Set<Review> getReviews(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        return product.getReviews();
    }

    @Override
    public Set<Purchase> getPurchases(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        return product.getPurchases();
    }
}
