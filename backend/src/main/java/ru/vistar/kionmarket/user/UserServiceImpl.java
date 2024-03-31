package ru.vistar.kionmarket.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.authority.Authority;
import ru.vistar.kionmarket.user.*;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.address.AddressRepository;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.product.ProductRepository;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.shop.ShopRepository;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final ShopRepository shopRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, AddressRepository addressRepository, ShopRepository shopRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.shopRepository = shopRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(UserDto userDto) {
        String email = userDto.getEmail();
        String password = passwordEncoder.encode(userDto.getPassword());
        String firstName = userDto.getFirstName();
        String middleName = userDto.getMiddleName();
        String lastName = userDto.getLastName();
        User user = new User(email,password,firstName,middleName,lastName);
        return userRepository.save(user);
    }

    @Override
    public User update(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(user.getMiddleName());
        user.setLastName(userDto.getLastName());
        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
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
