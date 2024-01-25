package dev.jabbaama.version1.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_menu")
    private Long id;
    private String nameMenu;
    private String photo;
    private String description;
    private int price;
    @ManyToOne(fetch =  FetchType.EAGER, optional = false, cascade = CascadeType.ALL     )
    @JoinColumn(name = "id_category", nullable = false)
    @JsonIgnore
    private Category category;
    //@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "menu")
    //private Set<Comment> comments = new HashSet<Comment>();
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

}
