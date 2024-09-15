package lazyprogrammer.jwtdemo.controllers;

import lazyprogrammer.jwtdemo.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/load-roles")
    public ResponseEntity<String> loadRoles() {
        roleService.loadRoles();
        return ResponseEntity.ok("SUCCESS");
    }
}
