package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.Category;
import ru.vistar.kionmarket.dto.CategoryDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);
    CategoryDto toDto(Category category);
    List<CategoryDto> toDto(List<Category> categories);
}
