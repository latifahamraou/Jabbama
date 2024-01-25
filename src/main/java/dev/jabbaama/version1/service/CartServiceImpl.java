/*
package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.AddMenuToCardDto;
import dev.jabbaama.version1.model.dto.OrderDto;
import dev.jabbaama.version1.model.entities.Menu;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.model.entities.OrderItem;
import dev.jabbaama.version1.model.entities.User;
import dev.jabbaama.version1.repository.MenuRepository;
import dev.jabbaama.version1.repository.OrderItemRepository;
import dev.jabbaama.version1.repository.OrderRepository;
import dev.jabbaama.version1.repository.UserRepository;
import dev.jabbaama.version1.service.mapper.OrderMapper;
import dev.jabbaama.version1.utilities.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl  implements  CartService{
    OrderRepository orderRepository;
    MenuRepository menuRepository;
    OrderItemRepository orderItemRepository;
    UserRepository userRepository;
   OrderMapper orderMapper;
    @Override
    public ResponseEntity<?> addMenuToCart(AddMenuToCardDto addMenuToCardDto){
        Order activeOrder= orderRepository.findOrderByUserIdAndOrderStatus(addMenuToCardDto.getIdUser(), OrderStatus.EN_COURS);
       // var activeOrder = order.get();
        Optional<OrderItem> orderItem = orderItemRepository.findOrderItemByOrderIdAndMenuId(activeOrder.getId(), addMenuToCardDto.getIdMenu(), addMenuToCardDto.getIdUser());
        if(orderItem.isPresent()){
          return   ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else{
            Optional<Menu> menu = menuRepository.findById(addMenuToCardDto.getIdMenu());
            Optional<User> user = userRepository.findById(addMenuToCardDto.getIdUser());
            if (menu.isPresent() && user.isPresent()){
            OrderItem cart= new OrderItem();
            cart.setMenu(menu.get());
            cart.setPrice(0L);
            cart.setQuantity(1);
            cart.setOrder(activeOrder);
            //cart.setUser(user);
                // orderItemRepository.save(cart);
                orderItemRepository.save(cart);
                activeOrder.setAmount((activeOrder.getAmount()+ cart.getPrice()));
                activeOrder.getOrderItemList().add(cart);
                orderRepository.save(activeOrder);
                return   ResponseEntity.status(HttpStatus.CREATED).body("user or product not found");

            }else {
                return   ResponseEntity.status(HttpStatus.NOT_FOUND).body("user or product not found");
            }

        }

    }

    @Override
    public OrderDto getCartByUser(Long userId) {
       Order activeOrder = orderRepository.findOrderByUserIdAndOrderStatus(userId, OrderStatus.EN_COURS);
        return orderMapper.toDto(activeOrder);



    }
}
*/
