/*
package dev.jabbaama.version1.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_comment")
    private Long id;
    private String comment;
    private Date commentDate;
    private int like;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_menu")
    private Menu menu;

}
*/
