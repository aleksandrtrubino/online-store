package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);
    List<UserDto> toDto(List<? extends User> users);
}
