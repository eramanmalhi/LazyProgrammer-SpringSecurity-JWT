package lazyprogrammer.jwtdemo.services;

import lazyprogrammer.jwtdemo.entities.Role;
import lazyprogrammer.jwtdemo.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void loadRoles() {
        List<Role> roles = new ArrayList<>();
        Role roleUser = new Role();
        roleUser.setRoleName("ROLE_USER");
        roles.add(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ROLE_ADMIN");
        roles.add(roleAdmin);
        roleRepository.saveAll(roles);
    }
}
