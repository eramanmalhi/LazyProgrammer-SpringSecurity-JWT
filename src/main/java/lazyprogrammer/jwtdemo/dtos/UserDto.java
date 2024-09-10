package lazyprogrammer.jwtdemo.dtos;

import lazyprogrammer.jwtdemo.entities.Roles;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String password;
    private List<Roles> roles;
}
