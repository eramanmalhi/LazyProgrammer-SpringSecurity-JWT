package lazyprogrammer.jwtdemo.dtos;

import lazyprogrammer.jwtdemo.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String username;
    private String password;
    private List<Roles> roles;
}
