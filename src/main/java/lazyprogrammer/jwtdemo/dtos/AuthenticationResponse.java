package lazyprogrammer.jwtdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {
    final private String jwt;
}
