package ru.vistar.kionmarket.product;

import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.productdiscount.ProductDiscount;
import ru.vistar.kionmarket.productprice.ProductPrice;
import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final String IMAGE_DIRECTORY = "src/main/resources/images/";
    private final String IMAGE_NAME_PREFIX = "product_";
    private final int MAX_IMAGES = 10;

    private final FileStorageService fileStorageService;

    public ProductMapperImpl(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
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
        else{
            priceWithDiscount = price.getPrice();
            discountValue = 0;
            isDiscount = false;
        }

        List<byte[]> images = new ArrayList<>();

        for(int i = 0; i < MAX_IMAGES; ++i){
            String fileName = IMAGE_NAME_PREFIX + id + "_" + i;
            if(fileStorageService.isFileExist(IMAGE_DIRECTORY,fileName)){
                byte[] image = fileStorageService.findFile(IMAGE_DIRECTORY, fileName);
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
