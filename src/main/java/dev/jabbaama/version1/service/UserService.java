package dev.jabbaama.version1.service;

import dev.jabbaama.version1.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    List<UserDto> listeUsers();
    UserDto addUser(UserDto userDto);
    UserDto updateUser(Long id,UserDto userDto);
    Boolean deleteUser(Long id);
    UserDto getUser(Long id);
}
