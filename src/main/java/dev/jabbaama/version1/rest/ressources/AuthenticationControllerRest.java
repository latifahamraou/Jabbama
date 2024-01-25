package dev.jabbaama.version1.rest.ressources;



import dev.jabbaama.version1.model.dto.request.SignInRequest;
import dev.jabbaama.version1.model.dto.request.SignUpRequest;
import dev.jabbaama.version1.model.dto.response.JwtAuthenticationResponse;
import dev.jabbaama.version1.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationControllerRest {
    private final AuthenticationService authenticationService;
    private HttpStatus httpStatus;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {

        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
