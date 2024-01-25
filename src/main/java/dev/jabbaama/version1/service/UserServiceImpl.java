package dev.jabbaama.version1.service;


import dev.jabbaama.version1.model.dto.UserDto;
import dev.jabbaama.version1.repository.UserRepository;
import dev.jabbaama.version1.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
    public List<UserDto> listeUsers(){
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }
    public UserDto addUser(UserDto userDto){

        var  user = userRepository.save(userMapper.toEntity(userDto));
         return userMapper.toDto(user);
    }
    public UserDto updateUser(Long id,UserDto userDto){
        var user = userRepository.findById(id).get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        var currentUser =  userRepository.save(user);
        return userMapper.toDto(currentUser);
    }
    public Boolean deleteUser(Long id){
        var user = userRepository.findById(id);
        userRepository.deleteById(id);
        return true;
    }
    public UserDto getUser(Long id){
         return userMapper.toDto(userRepository.findById(id).get());
    }
}