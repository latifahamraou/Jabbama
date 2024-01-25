package dev.jabbaama.version1.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orderItem")
    private Long id;
    private int quantity;
    private Long price;
    private Long cost;
    @ManyToOne(fetch =  FetchType.EAGER, optional = false, cascade = CascadeType.ALL     )
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;
    @ManyToOne(fetch =  FetchType.EAGER, optional = false, cascade = CascadeType.ALL )
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;




}
