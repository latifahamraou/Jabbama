package dev.jabbaama.version1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String name;

}
