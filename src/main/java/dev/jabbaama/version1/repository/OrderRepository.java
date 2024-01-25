package dev.jabbaama.version1.repository;

import dev.jabbaama.version1.model.entities.Category;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.utilities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByCodeOrderIgnoreCase(String codeOrder);

    Optional <Order> findOrderByCodeOrder(String  codeOrder);
   Order findOrderByUserIdAndOrderStatus(Long  userId, OrderStatus orderStatus);
    Optional <Category> findOrderById(Long id);

}
