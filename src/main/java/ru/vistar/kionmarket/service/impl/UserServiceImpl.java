package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.UserMapper;
import ru.vistar.kionmarket.repository.UserRepository;
import ru.vistar.kionmarket.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userDto.getId())));
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(user.getMiddleName());
        user.setLastName(userDto.getLastName());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",id)));
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
}
