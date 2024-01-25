package dev.jabbaama.version1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private long id;
    private String menuName;
    private String image;
    private Long price;
    private int quantity;
    private Long cost;



}
