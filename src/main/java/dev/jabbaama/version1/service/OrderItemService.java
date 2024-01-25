package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.model.entities.OrderItem;
import dev.jabbaama.version1.repository.OrderItemRepository;
import dev.jabbaama.version1.repository.MenuRepository;
import dev.jabbaama.version1.repository.OrderRepository;
import dev.jabbaama.version1.service.mapper.MenuMapper;
import dev.jabbaama.version1.service.mapper.OrderItemMapper;
import dev.jabbaama.version1.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuMapper menuMapper;

    public List<OrderItemDto> getOrderItemByOrder(Long id) {
        checkOrder(id);

        List<OrderItemDto> orderItemDtoList = orderItemRepository.findOrderItemByOrderId(id).stream().map(orderItemMapper::toDto).collect(Collectors.toList());
        return orderItemDtoList;
    }

    public OrderItemDto getOrderItem(Long id) {

        return orderItemRepository.findById(id).map(orderItemMapper::toDto).get();
    }

   /* public Long addOrderItem(Long idOrder, Long idMenu, OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDto);
        menuRepository.findById(idMenu).map(menu -> {
                    orderItem.setMenu(menu);
                    return idMenu;
                })
                .orElseThrow(() -> new RuntimeException("Not found menu with id=" + idMenu));
        orderRepository.findById(idOrder).map(order -> {
                    orderItem.setOrder(order);
                    return idOrder;
                })
                .orElseThrow(() -> new RuntimeException("Not found order with id=" + idOrder));
        return orderItemRepository.save(orderItem).getId();

    }*/

    public Boolean updateOrderItem(Long id, OrderItemDto orderItemDto) {
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("code 101: aucune ligneCommande avec ce id trouvé " + id));
    /*cartItem.setCost(cartItemDto.getCost());
    cartItem.setQuantity(cartItem.getQuantity());

     */
        orderItemMapper.copy(orderItemDto, orderItem);
        orderItemRepository.save(orderItem);
        return true;
    }

    public Boolean deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
        return true;
    }

    public Boolean deleteAllTheOrderItemByOrder(Long idOrder) {
        checkOrder(idOrder);
        Order order = orderRepository.findById(idOrder).get();
        orderItemRepository.deleteByOrder(order);
        return true;
    }

    private void checkOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Not found Order with id = " + id);
        }
    }


}


