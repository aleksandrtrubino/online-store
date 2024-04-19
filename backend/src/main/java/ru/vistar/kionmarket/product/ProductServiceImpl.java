package ru.vistar.kionmarket.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.exception.ResourceAlreadyExistsException;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.shop.ShopRepository;
import ru.vistar.kionmarket.subcategory.SubcategoryRepository;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final ProductMapper productMapper;
    private final FileStorageService fileStorageService;


    private final String IMAGE_DIRECTORY = "src/main/resources/images/";
    private final String IMAGE_NAME_PREFIX = "product_";
    private final int MAX_IMAGES = 10;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SubcategoryRepository subcategoryRepository, FileStorageService fileStorageService, ProductMapperImpl productMapper) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.fileStorageService = fileStorageService;
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
            if(!fileStorageService.isFileExist(IMAGE_DIRECTORY, fileName)){
                fileStorageService.saveFile(images[imageIndex], IMAGE_DIRECTORY, fileName);
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
            if(fileStorageService.isFileExist(IMAGE_DIRECTORY,fileName)){
                byte[] image = fileStorageService.findFile(IMAGE_DIRECTORY, fileName);
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
    public List<ProductResponseDto> findAll() {
        return productMapper.toDto(productRepository.findAll());
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
