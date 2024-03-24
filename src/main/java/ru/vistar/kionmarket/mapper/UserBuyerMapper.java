package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapping;
import ru.vistar.kionmarket.domain.UserBuyer;
import ru.vistar.kionmarket.dto.UserBuyerDto;


import java.util.List;

public interface UserBuyerMapper {
    UserBuyer toEntity(UserBuyerDto userBuyerDto);
    UserBuyerDto toDto(UserBuyer userBuyer);
    List<UserBuyerDto> toDto(List<UserBuyer> userBuyers);
}
