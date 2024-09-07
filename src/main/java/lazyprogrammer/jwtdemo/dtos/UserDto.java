package lazyprogrammer.jwtdemo.dtos;

import lombok.Data;

@Data
public class UserDto {
    private long userId;
    private String username;
    private String password;
}
