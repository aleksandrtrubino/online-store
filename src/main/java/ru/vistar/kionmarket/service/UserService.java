package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.AuthorityDto;
import ru.vistar.kionmarket.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {

    public UserDto create(UserDto userDto);//users
    public UserDto update(Long userid, UserDto userDto);//users/{userId}
    public UserDto findById(Long id);//users/{id}
    public List<UserDto> findAll();//users
    public void deleteById(Long id);//users/{id}

    public Set<Authority> getAuthorities(Long userId);//users/{userId}/authorities

    public Set<Review> getReviews(Long userId);//users/{userId}/reviews
    public Set<Purchase> getPurchases(Long userId);//users/{userId}/purchases

    public Set<Product> getFavorites(Long userId);//users/{userId}/favorites
    public void addFavorite(Long userId, Long productId);//users/{userId}/favorites/{productId}
    public void removeFavorite(Long userId, Long productId);//users/{userId}/favorites/{productId}

    public Address getAddress(Long userId);//users/{userId}/addresses
    public void addAddress(Long userId, Long addressId);//users/{userId}/addresses/{addressId}
    public void removeAddress(Long userId);//users/{userId}/addresses

    public Shop getShop(Long userId);//users/{userId}/shops
    public void addShop(Long userId, Long shopId);//users/{userId}/shops/{shopId}
    public void removeShop(Long userId);//users/{userId}/shops




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



}