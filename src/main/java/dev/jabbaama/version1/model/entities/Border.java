package dev.jabbaama.version1.model.entities;

import dev.jabbaama.version1.utilities.OrderStatus;
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
public class Border {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_border")
    private Long id;
    
    private String codeOrder;
    private double total;
    private String comment;
    @Enumerated(EnumType.STRING)
    private OrderStatus commandStatus;

}
