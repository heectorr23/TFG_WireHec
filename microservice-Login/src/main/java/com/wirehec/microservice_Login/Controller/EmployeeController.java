package com.wirehec.microservice_Login.Controller;

import com.wirehec.microservice_Login.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Login.Entity.ERole;
import com.wirehec.microservice_Login.Entity.EmployeeEntity;
import com.wirehec.microservice_Login.Entity.RoleEntity;
import com.wirehec.microservice_Login.Repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class EmployeeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello World Secured";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody EmployeeDTO createUserDTO) {
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(String.valueOf(role)))
                        .build())
                .collect(Collectors.toSet());

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .username(createUserDTO.getUsername())
                .passwordEmpleado(passwordEncoder.encode(createUserDTO.getPasswordEmpleado()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();
        employeeRepository.save(employeeEntity);
        return ResponseEntity.ok(employeeEntity);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String id) {
        employeeRepository.deleteById(Long.parseLong(id));
        return "User deleted ".concat(id);
    }
}