package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.AddMenuToCardDto;
import dev.jabbaama.version1.model.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
     ResponseEntity<?> addMenuToCart(AddMenuToCardDto addMenuToCardDto);
     OrderDto getCartByUser(Long userId);
}
