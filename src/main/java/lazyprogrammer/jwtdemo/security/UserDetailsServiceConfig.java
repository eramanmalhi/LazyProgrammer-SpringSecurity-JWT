package lazyprogrammer.jwtdemo.security;

import lazyprogrammer.jwtdemo.entities.Roles;
import lazyprogrammer.jwtdemo.entities.User;
import lazyprogrammer.jwtdemo.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isEmpty()) {
                throw new UsernameNotFoundException("User not found");
            }
            List<Roles> roles = user.get().getRoles();
            List<SimpleGrantedAuthority> authorities = roles.stream().map(r -> new SimpleGrantedAuthority(r.getValue())).toList();
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), authorities);
        };
    }
}

