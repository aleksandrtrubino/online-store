package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.UserMapper;
import ru.vistar.kionmarket.repository.AddressRepository;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.repository.ShopRepository;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.service.UserService;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ProductRepository productRepository;
    final AddressRepository addressRepository;
    final ShopRepository shopRepository;
    final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, AddressRepository addressRepository, ShopRepository shopRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.shopRepository = shopRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(user.getPassword());
        user.setFirstName(user.getFirstName());
        user.setMiddleName(user.getMiddleName());
        user.setLastName(user.getLastName());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(user.getMiddleName());
        user.setLastName(userDto.getLastName());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto findById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Set<Authority> getAuthorities(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getAuthorities();
    }

    @Override
    public Set<Review> getReviews(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getReviews();
    }

    @Override
    public Set<Purchase> getPurchases(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getPurchases();
    }

    @Override
    public Set<Product> getFavorites(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getFavorites();
    }

    @Override
    public void addFavorite(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found",userId)));
        user.getFavorites().add(product);
        userRepository.save(user);
    }

    @Override
    public void removeFavorite(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        productRepository.findById(productId)
                .ifPresent(product -> {
                    user.getFavorites().remove(product);
                    userRepository.save(user);
                });
    }

    @Override
    public Address getAddress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getAddress();
    }

    @Override
    public void addAddress(Long userId, Long addressId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",userId)));
        user.setAddress(address);
        userRepository.save(user);
    }

    @Override
    public void removeAddress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        user.setAddress(null);
        userRepository.save(user);
    }

    @Override
    public Shop getShop(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        return user.getShop();
    }

    @Override
    public void addShop(Long userId, Long shopId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Shop with id %1$s not found",userId)));
        user.setShop(shop);
        userRepository.save(user);
    }

    @Override
    public void removeShop(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        user.setShop(null);
        userRepository.save(user);
    }


}