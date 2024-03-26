package ru.vistar.kionmarket.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);
    List<UserDto> toDto(List<? extends User> users);
}
