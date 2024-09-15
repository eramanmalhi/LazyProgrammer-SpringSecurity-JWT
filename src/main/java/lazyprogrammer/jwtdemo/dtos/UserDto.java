package lazyprogrammer.jwtdemo.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String password;
    private List<String> roles;
}
