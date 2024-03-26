package ru.vistar.kionmarket.shop;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.product.Product;

import java.util.List;
import java.util.Set;
@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop create(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        return shopRepository.save(shop);
    }

    @Override
    public Shop update(Long id, ShopDto shopDto) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", id)));
        shop.setName(shopDto.getName());
        return shopRepository.save(shop);
    }

    @Override
    public Shop findById(Long shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", shopId)));
        return shop;
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public void deleteById(Long shopId) {
        shopRepository.deleteById(shopId);
    }

    @Override
    public Set<Product> getProducts(Long shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Category with id %1$s not found", shopId)));
        return shop.getProducts();
    }
}
