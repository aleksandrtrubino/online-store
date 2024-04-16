package ru.vistar.kionmarket.userdiscounts;

import java.util.List;

public interface UserDiscountService {
    public UserDiscount create(UserDiscountDto userDiscountDto);
    public UserDiscount update(Long id, UserDiscountDto userDiscountDto);
    public UserDiscount findById(Long id);
    public List<UserDiscount> findAll();
    public void deleteById(Long id);
}
