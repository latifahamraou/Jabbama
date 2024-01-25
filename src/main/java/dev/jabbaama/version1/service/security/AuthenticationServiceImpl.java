package dev.jabbaama.version1.service.security;


import dev.jabbaama.version1.model.dto.request.SignInRequest;
import dev.jabbaama.version1.model.dto.request.SignUpRequest;
import dev.jabbaama.version1.model.dto.response.JwtAuthenticationResponse;
import dev.jabbaama.version1.model.entities.Order;
import dev.jabbaama.version1.model.entities.Role;
import dev.jabbaama.version1.model.entities.User;
import dev.jabbaama.version1.repository.OrderRepository;
import dev.jabbaama.version1.repository.UserRepository;
import dev.jabbaama.version1.utilities.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        hasNoUserWithEmail(request.getEmail());
       /* if(request.getPassword() != request.getConfirmPassword()){
            throw new RuntimeException("Password not match");
        }*/
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }


    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
     /*  var order =  Order.builder().build();
        order.setCodeOrder("");
        order.setTotalAmount(0L);
        order.setDiscount(0L);
        order.setOrderStatus(OrderStatus.EN_COURS);
        order.setUser(user);
        orderRepository.save(order);*/
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public Boolean hasNoUserWithEmail(String email) {

        if (userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("Il existe un utilisateur avec cet email");
        }
        return true;
    }


 /*var order =  Order.builder().build();
            order.setCodeOrder("");
            order.setTotalAmount(0L);
            order.setDiscount(0L);
            order.setCommandStatus(CommandStatus.EN_COURS);
            order.setUser(user);
            orderRepository.save(order);*/

}
