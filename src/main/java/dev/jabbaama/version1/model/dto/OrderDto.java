package dev.jabbaama.version1.model.dto;


import dev.jabbaama.version1.model.entities.Adress;
import dev.jabbaama.version1.model.entities.OrderItem;
import dev.jabbaama.version1.model.entities.User;
import dev.jabbaama.version1.utilities.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String codeOrder;
    private double totalAmount;
    private String userName;
    //private String orderDescriptionn;

    private Date date;
    private Long discount;
    private Long payment;
    private UUID trackingId;
    private String comment;
    private boolean ispaid;
    private OrderStatus orderStatus;
    private Long  deliveryFees;
    private Adress deliveryAddress;
    private List<OrderItemDto> orderItemDtos;

}
