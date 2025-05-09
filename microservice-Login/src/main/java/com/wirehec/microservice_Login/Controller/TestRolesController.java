package com.wirehec.microservice_Login.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {
    @GetMapping("/accessBOSS")
    @PreAuthorize("hasRole('BOSS')")
    public String accessBoss(){
        return "Hola has accedido con el rol BOSS";
    }

    @GetMapping("/accessuser")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return "Hola has accedido con el rol USER";
    }

    @GetMapping("/accessCommercial")
    @PreAuthorize("hasRole('COMMERCIAL')")
    public String accessCommercial(){
        return "Hola has accedido con el rol COMMERCIAL";
    }
}
