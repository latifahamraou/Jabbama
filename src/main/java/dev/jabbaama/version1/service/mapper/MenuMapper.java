package dev.jabbaama.version1.service.mapper;


import dev.jabbaama.version1.model.dto.MenuDto;
import dev.jabbaama.version1.model.entities.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface MenuMapper {
  Menu toEntity(MenuDto menuDto);
  MenuDto toDto(Menu menu);

  void copy(MenuDto menuDto, @MappingTarget Menu menu);
}
