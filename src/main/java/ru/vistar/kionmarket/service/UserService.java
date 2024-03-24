package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.AuthorityDto;
import ru.vistar.kionmarket.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto create(UserDto userDto);//users
    public UserDto update(UserDto userDto);//users
    public UserDto findById(Long id);//users/{id}
    public List<UserDto> findAll();//users
    public void deleteById(Long id);//users/{id}

//    public List<AuthorityDto> getAuthoritiesById(Long id);//users/{id}/authorities
//    public List<ProductDto> getFavoritesById(Long id);//users/{id}/favorites
//    public List<PurchaseDto> getPurchasesById(Long id);//users/{id}/purchases
//    public List<ReviewDto> getReviewsById(Long id);//users/{id}/reviews


}
