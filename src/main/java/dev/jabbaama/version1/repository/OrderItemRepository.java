package dev.jabbaama.version1.repository;

import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.model.entities.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long > {
    Optional<OrderItem> findById(Long id);
    boolean existsById(Long id);
    Optional<OrderItem> findOrderItemByOrderId(Long id_order);
    @Transactional
    Boolean deleteByOrder(Order order);

    Optional<OrderItem> findOrderItemByOrderIdAndMenuId(Long oderId, Long menuId);
}
