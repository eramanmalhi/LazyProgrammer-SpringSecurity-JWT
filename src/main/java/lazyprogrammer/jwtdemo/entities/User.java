package lazyprogrammer.jwtdemo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USER_DETAILS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(unique = true, length = 20)
    private String username;
    private String password;
    private List<Roles> roles;
}
