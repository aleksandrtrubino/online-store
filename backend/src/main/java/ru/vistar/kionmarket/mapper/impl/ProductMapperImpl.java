package ru.vistar.kionmarket.mapper.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.dto.ProductResponseDto;
import ru.vistar.kionmarket.mapper.ProductMapper;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.util.FileStorageUtil;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.ProductDiscount;
import ru.vistar.kionmarket.domain.ProductPrice;
import ru.vistar.kionmarket.domain.Shop;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final String IMAGE_DIRECTORY = "backend/src/main/resources/images/";
    private final String IMAGE_NAME_PREFIX = "product_";
    private final int MAX_IMAGES = 10;

    private final FileStorageUtil fileStorageUtil;
    private final UserRepository userRepository;


    public ProductMapperImpl(FileStorageUtil fileStorageUtil, UserRepository userRepository) {
        this.fileStorageUtil = fileStorageUtil;
        this.userRepository = userRepository;
    }

    @Override
    public ProductResponseDto toDto(Product product) {
        Long id = product.getId();
        String name = product.getName();
        String description = product.getDescription();
        ProductPrice price = product.getPrice();
        ProductDiscount discount = product.getDiscount();
        Subcategory subcategory = product.getSubcategory();
        Shop shop = product.getShop();

        Double priceWithDiscount;
        Integer discountValue;
        Boolean isDiscount;
        if(discount != null && discount.getValue() != 0){
            Double percent = (1 - (double)discount.getValue() / 100);
            priceWithDiscount = price.getPrice() * percent;
            discountValue = discount.getValue();
            isDiscount = true;
        }
        else if (price != null){
            priceWithDiscount = price.getPrice();
            discountValue = 0;
            isDiscount = false;
        }
        else {
            priceWithDiscount = null;
            discountValue = 0;
            isDiscount = false;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = Long.parseLong(userDetails.getUsername());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with id %1$s not found", userId)));
        Set<Product> favorites = user.getFavorites();

        Boolean isFavorite = favorites.contains(product);

        List<byte[]> images = new ArrayList<>();

        for(int i = 0; i < MAX_IMAGES; ++i){
            String fileName = IMAGE_NAME_PREFIX + id + "_" + i +".webp";
            if(fileStorageUtil.isFileExist(IMAGE_DIRECTORY,fileName)){
                byte[] image = fileStorageUtil.findFile(IMAGE_DIRECTORY, fileName);
                images.add(image);
            }
            else
                break;
        }

        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(id);
        responseDto.setName(name);
        responseDto.setDescription(description);
        responseDto.setPrice(priceWithDiscount);
        responseDto.setDiscount(discountValue);
        responseDto.setIsDiscount(isDiscount);
        responseDto.setIsFavorite(isFavorite);
        responseDto.setSubcategory(subcategory);
        responseDto.setShop(shop);
        responseDto.setImages(images);

        return responseDto;
    }

    @Override
    public List<ProductResponseDto> toDto(List<Product> products) {
        List<ProductResponseDto> responseDtos = new ArrayList<>();
        for(Product product : products){
            ProductResponseDto responseDto = toDto(product);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }
}