package dev.jabbaama.version1.model.entities;

import dev.jabbaama.version1.utilities.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order")
    private Long id;

    private String codeOrder;
    private Date dateOrder;
    private Long totalAmount;
    private Long amount;
    private Long discount;
    private String payment;
    private String comment;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    @Column(insertable=false, updatable=false)
    private List<OrderItem> orderItemList;

    @ManyToOne( cascade = CascadeType.MERGE )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private Long  deliveryFees;
    @Embedded
    private Adress deliveryAddress;
}
