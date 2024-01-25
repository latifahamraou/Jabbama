package dev.jabbaama.version1.rest.ressources;

import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/OrderItem")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemControllerRest {
  
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{idOrder}/OrderItem")
    public ResponseEntity<List<OrderItemDto>> getAllOrderItemByOrder(@PathVariable(value = "idOrder") Long idOrder) {
        return ResponseEntity.ok(orderItemService.getOrderItemByOrder(idOrder));
    }

   /* @PostMapping("/{idOrder}/{idMenu}/create")
    public ResponseEntity<Long> addItemtoOrder(@PathVariable(value = "idOrder") Long idOrder, @PathVariable(value = "idMenu") Long idMenu, @RequestBody OrderItemDto OrderItemDto) {
        return ResponseEntity.ok(orderItemService.addOrderItem(idOrder,idMenu, OrderItemDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateOrderItem(@PathVariable(value = "id") Long id,@RequestBody OrderItemDto OrderItemDto) {
        return ResponseEntity.ok(orderItemService.updateOrderItem(id, OrderItemDto));
    }

    @GetMapping("/Orders/{id}")
    public ResponseEntity<OrderItemDto> viewOrderItem(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderItemService.getOrderItem(id));
    }

    @DeleteMapping("/Orders/{id}")
    public ResponseEntity<Boolean> deleteOrderItem(@PathVariable(value = "idOrderItem") Long idOrderItem) {
        return ResponseEntity.ok(orderItemService.deleteOrderItem(idOrderItem));
    }*/
    @DeleteMapping("/{IdOrder}/OrderItems")
    public ResponseEntity<Boolean> deleteAllTheOrderItemByOrder(@PathVariable (value = "idOrder") long idOrder){
        return ResponseEntity.ok(orderItemService.deleteAllTheOrderItemByOrder(idOrder));
    }

}




