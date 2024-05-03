package ru.vistar.kionmarket.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.domain.Authority;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;

import java.util.List;
import java.util.Set;

public interface UserService {

    public User create(UserDto userDto);//users
    public User update(Long userid, UserDto userDto);//users/{userId}
    public User findById(Long id);//users/{id}
    public List<User> findAll();//users
    public void deleteById(Long id);//users/{id}

    public Set<Authority> getAuthorities(Long userId);//users/{userId}/authorities

    public Set<Review> getReviews(Long userId);//users/{userId}/reviews
    public Set<Purchase> getPurchases(Long userId);//users/{userId}/purchases

    public Set<Product> getFavorites(Long userId);//users/{userId}/favorites
    public void addFavorite(Long userId, Long productId);//users/{userId}/favorites/{productId}
    public void removeFavorite(Long userId, Long productId);//users/{userId}/favorites/{productId}



    //AUTHORITIES
//    1
//    2
//    3
//    4
//    5

//    public void grantAuthority(Long userId, Long authorityId);//authorities/{authorityId}/users/{userId}
//    public void revokeAuthority(Long userId, Long authorityId);//authorities/{authorityId}/users/{userId}


    //PURCHASES
    // public Purchase create(PurchaseDto purchaseDto);//purchases
//    public Purchase update(PurchaseDto purchaseDto);//purchases
//    public Purchase findById(Long id);//purchases/{id}
//    public List<Purchase> findAll();//purchases
//    public void deleteById(Long id);//purchases/{id}

    //REVIEWS
    //
    //
    //
    //
    //


//    public AddressDto getAddressById(Long id);//users/{userId}/addresses
//    public void setAddress(Long userId, long addressId);//users/{userId}/addresses/{addressId}
//    public void removeAddress(Long userId, long addressId);//users/{userId}/addresses/{addressId}
//
//
//    public ShopDto getShop(Long id);//users/{id}/shops
//    public void setShop(Long id, Long shopId);//users/{userId}/shops/{shopId}
//    public void removeShop(Long id, Long shopId);//users/{userId}/shops/{shopId}


    //PRODUCTS
//    public Product create(ProductDto productDto);//products
//    public Product update(ProductDto productDto);//products
//    public Product findById(Long id);//products/{id}
//    public List<Product> findAll();//products
//    public void deleteById(Long id);//products/{id}

//    public List<ReviewDto> getReviews(Long productId);//products/{productId}/reviews
//    public List<PurchaseDto> getPurchases(Long purchaseId);//products/{productId}/purchases


    @Service
    @Transactional
    class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final ProductRepository productRepository;
        private final PasswordEncoder passwordEncoder;

        public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.productRepository = productRepository;
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

    }
}
