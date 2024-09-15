package lazyprogrammer.jwtdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/secure")
    public ResponseEntity<String> secureResource() {
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/secure/user")
    public ResponseEntity<String> secureUser() {
        return ResponseEntity.ok("USER/ADMIN: Access Granted");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/secure/admin")
    public ResponseEntity<String> secureAdmin() {
        return ResponseEntity.ok("ADMIN: Access Granted");
    }
}
