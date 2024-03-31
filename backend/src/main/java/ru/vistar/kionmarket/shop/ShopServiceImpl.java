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
        String name = shopDto.getName();
        Shop shop = new Shop(name);
        return shopRepository.save(shop);
    }

    @Override
    public Shop update(Long shopId, ShopDto shopDto) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Shop with id %1$s not found", shopId)));
        shop.setName(shopDto.getName());
        return shopRepository.save(shop);
    }

    @Override
    public Shop findById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Shop with id %1$s not found", shopId)));
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
                .orElseThrow(()->new ResourceNotFoundException(String.format("Shop with id %1$s not found", shopId)));
        return shop.getProducts();
    }
}
