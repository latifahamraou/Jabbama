package dev.jabbaama.version1.rest.ressources;

import dev.jabbaama.version1.model.dto.UserDto;
import dev.jabbaama.version1.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerRest {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = new ArrayList<>();
        users = userService.listeUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "id") Long id){

        return ResponseEntity.ok(userService.getUser(id));
    }
    @PostMapping("/create")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.addUser(userDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
