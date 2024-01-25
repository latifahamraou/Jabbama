
package dev.jabbaama.version1.model.dto;

import dev.jabbaama.version1.model.entities.Adress;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 public class UserDto {
   private String firstName;
   private String lastName;
   private String email;
   private Adress adress;
   private String password;
   //List<CommandeDto> listCommandes;


}
