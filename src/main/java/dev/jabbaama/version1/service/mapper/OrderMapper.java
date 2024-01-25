package dev.jabbaama.version1.service.mapper;

import dev.jabbaama.version1.model.dto.OrderDto;
import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.model.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
    void copy(OrderDto orderDto, @MappingTarget Order order);
    OrderItemDto toOrderItemDto(OrderItem orderItem);
    OrderItem toOrderItem(OrderItemDto orderItemDto);


}
