package ru.vistar.kionmarket.userdiscounts;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.user.UserRepository;

import java.util.List;
@Service
public class UserDiscountServiceImpl implements UserDiscountService{
    private final UserRepository userRepository;
    private final UserDiscountRepository userDiscountRepository;

    public UserDiscountServiceImpl(UserRepository userRepository, UserDiscountRepository userDiscountRepository) {
        this.userRepository = userRepository;
        this.userDiscountRepository = userDiscountRepository;
    }

    @Override
    public UserDiscount create(UserDiscountDto userDiscountDto) {
        User user = userRepository.findById(userDiscountDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found", userDiscountDto.getUserId())));
        UserDiscount userDiscount = new UserDiscount();
        userDiscount.setUser(user);
        userDiscount.setValue(userDiscountDto.getValue());
        return userDiscountRepository.save(userDiscount);
    }

    @Override
    public UserDiscount update(Long id, UserDiscountDto userDiscountDto) {
        UserDiscount userDiscount = userDiscountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("UserDiscount with id %1$s not found", id)));
        User user = userRepository.findById(userDiscountDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found", userDiscountDto.getUserId())));
        userDiscount.setUser(user);
        userDiscount.setValue(userDiscountDto.getValue());
        return userDiscountRepository.save(userDiscount);
    }

    @Override
    public UserDiscount findById(Long id) {
        UserDiscount userDiscount = userDiscountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("UserDiscount with id %1$s not found", id)));
        return userDiscount;
    }

    @Override
    public List<UserDiscount> findAll() {
        return userDiscountRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userDiscountRepository.deleteById(id);
    }
}
