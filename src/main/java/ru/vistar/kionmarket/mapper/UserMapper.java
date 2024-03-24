package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);
    List<UserDto> toDto(List<User> users);
}
