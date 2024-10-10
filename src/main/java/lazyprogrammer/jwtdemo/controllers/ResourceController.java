package lazyprogrammer.jwtdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @GetMapping("/secure")
    @PreAuthorize("hasAuthority('NORMAL') or hasAuthority('ADMIN')")
    public ResponseEntity<String> secureResource(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> adminResource(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }

    @GetMapping("/normal")
    @PreAuthorize("hasAuthority('NORMAL')")
    public ResponseEntity<String> normalResource(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        return ResponseEntity.ok("Yes, Your JWT Works...");
    }


}
