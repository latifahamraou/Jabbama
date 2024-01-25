package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.OrderDto;
import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.repository.MenuRepository;
import dev.jabbaama.version1.repository.OrderItemRepository;
import dev.jabbaama.version1.repository.OrderRepository;
import dev.jabbaama.version1.repository.UserRepository;
import dev.jabbaama.version1.service.mapper.OrderItemMapper;
import dev.jabbaama.version1.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private MenuRepository menuRepository;
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    public OrderDto getAnOrder(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto).get();
    }

   /* public Long createAnOrder(String email, OrderDto orderDto) {
        var user = userRepository.findByEmail(email).get();
        var order = orderMapper.toEntity(orderDto);
        order.setUser(user);
        return orderRepository.save(order).getId();
    }*/
   //String email,
   public Long createAnOrder( OrderDto orderDto) {
     //  var user = userRepository.findByEmail(email).get();
       var order = orderMapper.toEntity(orderDto);
     //  order.setUser(user);
       orderRepository.save(order);
       addOrderItems(orderDto, order);
       return order.getId();
   }

   public void addOrderItems(OrderDto orderDto, Order order){

       orderDto.getOrderItemDtos().stream().map(orderItemDto -> {
                   var orderItem = orderItemMapper.toEntity(orderItemDto);
                   orderItem.setOrder(order);
                   orderItem.setMenu(menuRepository.findMenuById(orderItem.getId()));
                  // orderItem.setPrice(orderItemDto.getPrice());
                    return orderItemRepository.save(orderItem);
               }
               );

   }

    public boolean updateAnOrder(Long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).get();
        order.setCodeOrder(orderDto.getCodeOrder());
        order.setComment(orderDto.getComment());
       // order.setOrderItemList(orderDto.getOrderItemDtos().stream().map(orderItemMapper::toEntity).collect(Collectors.toList()));
        orderMapper.copy(orderDto, order);
        orderRepository.save(order);
        return true;
    }
    public boolean deleteAnOrder(Long id){
        orderRepository.deleteById(id);
        return true;
    }
}
