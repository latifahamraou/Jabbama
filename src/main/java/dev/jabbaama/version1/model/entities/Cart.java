/*package dev.jabbaama.version1.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cartItem")
    private Long id;
    private  float total;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "cart")
    private List<CartItem> cartItemList = new ArrayList<CartItem>();
    @OneToOne
    private Order order;

}


 */