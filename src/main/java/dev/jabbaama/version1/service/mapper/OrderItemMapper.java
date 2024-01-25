package dev.jabbaama.version1.service.mapper;

import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.model.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface OrderItemMapper {
    OrderItem toEntity(OrderItemDto orderItemDto);
    OrderItemDto toDto(OrderItem orderItem);
    void copy(OrderItemDto orderItemDtoDto, @MappingTarget OrderItem orderItem);
}
