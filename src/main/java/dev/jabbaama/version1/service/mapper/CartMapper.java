/*package dev.jabbaama.version1.service.mapper;

import dev.jabbaama.version1.model.dto.CartDto;
import dev.jabbaama.version1.model.entities.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface CartMapper {
    Cart toEntity(CartDto cartDto);
    CartDto toDto(Cart cart);
    void copy(CartDto cartDto, @MappingTarget Cart cart);
}


 */