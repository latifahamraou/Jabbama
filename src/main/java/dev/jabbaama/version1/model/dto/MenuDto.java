package dev.jabbaama.version1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long id;
    private String nameMenu;
    private String photo;
    private String description;
    private int price;
  //  private CategoryDto categoryDto;


}


