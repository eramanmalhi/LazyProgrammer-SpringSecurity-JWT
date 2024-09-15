package lazyprogrammer.jwtdemo.services;

import lazyprogrammer.jwtdemo.dtos.UserDto;
import lazyprogrammer.jwtdemo.entities.Role;
import lazyprogrammer.jwtdemo.entities.User;
import lazyprogrammer.jwtdemo.exceptions.RolesNotAvailableException;
import lazyprogrammer.jwtdemo.repositories.RoleRepository;
import lazyprogrammer.jwtdemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public ResponseEntity<UserDto> saveUser(UserDto dto) {
        User entity = new User();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        BeanUtils.copyProperties(dto, entity);
        List<Role> roles = roleRepository.findByRoleNameIn(dto.getRoles());
        if (dto.getRoles().size() != roles.size()) {
            throw new RolesNotAvailableException(dto.getRoles());
        }
        entity.setRoles(Set.copyOf(roles));
        User savedUser = userRepository.save(entity);
        dto.setPassword("******");
        dto.setUserId(savedUser.getUserId());
        return ResponseEntity.ok(dto);
    }

    public boolean findByUsername(String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        return byUsername.isPresent();
    }
}
