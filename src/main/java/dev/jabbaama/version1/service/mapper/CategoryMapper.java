package dev.jabbaama.version1.service.mapper;


import dev.jabbaama.version1.model.dto.CategoryDto;
import dev.jabbaama.version1.model.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);
    CategoryDto toDto(Category category);

    void copy (CategoryDto categoryDto, @MappingTarget Category category);

}
