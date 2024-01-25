package dev.jabbaama.version1.rest.ressources;

import dev.jabbaama.version1.model.dto.AddMenuToCardDto;
import dev.jabbaama.version1.model.dto.OrderDto;

import dev.jabbaama.version1.model.dto.OrderItemDto;
import dev.jabbaama.version1.service.CartService;
import dev.jabbaama.version1.service.OrderItemService;
import dev.jabbaama.version1.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderRestController {
    @Autowired
    public OrderService orderService;
    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllCategories() {
        List <OrderDto> orders = new ArrayList<>();
        orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);

    }
/*
    @PostMapping("/create/{email}")
    public ResponseEntity<Long> addOrder(@PathVariable(value = "email") String email, @RequestBody OrderDto oderDto) {
        return ResponseEntity.ok(orderService.createAnOrder(email, oderDto));
    }*/
    @PostMapping("/create/")
    public ResponseEntity<Long> addOrder(@RequestBody OrderDto oderDto) {
        return ResponseEntity.ok(orderService.createAnOrder( oderDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateOrder(@PathVariable(value = "id") Long idOrder, @RequestBody OrderDto oderDto) {

        return ResponseEntity.ok(orderService.updateAnOrder(idOrder, oderDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(orderService.getAnOrder(id));
    }

    @DeleteMapping("/delete/{idOrder}")
    public ResponseEntity<Boolean> deleteOrderById(@PathVariable(value = "idOrder") Long id) {
        return ResponseEntity.ok(orderService.deleteAnOrder(id));
    }
   /* @PostMapping("/cart/")
    public   ResponseEntity<?> addMenuToCart(@RequestBody AddMenuToCardDto addMenuToCardDto){
        return cartService.addMenuToCart(addMenuToCardDto);
    }*/
   /* @PostMapping("/cart/")
    public   ResponseEntity<OrderDto> getCartByUser(@PathVariable Long userId){
        return  ResponseEntity.ok(cartService.getCartByUser(userId));
    }*/


}
