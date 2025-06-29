package com.wirehec.microservice_Login.Controller;

import com.wirehec.microservice_Login.Controller.DTO.EmployeeDTO;
import com.wirehec.microservice_Login.Entity.ERole;
import com.wirehec.microservice_Login.Entity.EmployeeEntity;
import com.wirehec.microservice_Login.Entity.RoleEntity;
import com.wirehec.microservice_Login.Repository.EmployeeRepository;
import com.wirehec.microservice_Login.Service.Impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;
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

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World Not Secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello World Secured";
    }

    @PreAuthorize("hasRole('BOSS')")
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody EmployeeDTO createUserDTO) {

        if (createUserDTO.getUsername() == null || createUserDTO.getUsername().isEmpty()) {
            log.error("El campo 'username' es null o está vacío.");
            throw new IllegalArgumentException("El campo 'username' no puede ser null o vacío.");
        }

        if (createUserDTO.getPasswordEmpleado() == null || createUserDTO.getPasswordEmpleado().isEmpty()) {
            log.error("El campo 'passwordEmpleado' es null o está vacío.");
            throw new IllegalArgumentException("El campo 'passwordEmpleado' no puede ser null o vacío.");
        }

        if (passwordEncoder == null) {
            log.error("El PasswordEncoder no está configurado.");
            throw new IllegalStateException("El PasswordEncoder no puede ser null.");
        }

        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> {
                    if (role.getName() == null) {
                        log.error("El campo 'name' del rol es null.");
                        throw new IllegalArgumentException("El campo 'name' del rol no puede ser null.");
                    }
                    return RoleEntity.builder()
                            .name(ERole.valueOf(role.getName().name()))
                            .build();
                })
                .collect(Collectors.toSet());

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .nombreEmpleado(createUserDTO.getNombreEmpleado())
                .nifEmpleado(createUserDTO.getNifEmpleado())
                .telefonoEmpleado(createUserDTO.getTelefonoEmpleado())
                .email(createUserDTO.getEmail())
                .username(createUserDTO.getUsername())
                .passwordEmpleado(passwordEncoder.encode(createUserDTO.getPasswordEmpleado()))
                .roles(roles)
                .beneficioEmpleado(createUserDTO.getBeneficioEmpleado())
                .horaEntrada(createUserDTO.getHoraEntrada())
                .horaSalida(createUserDTO.getHoraSalida())
                .salario(createUserDTO.getSalario())
                .build();

        log.info("Usuario a guardar: " + employeeEntity);

        employeeRepository.save(employeeEntity);
        return ResponseEntity.ok(employeeEntity);
    }
    @PutMapping("/changePassword")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('BOSS')")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> passwordRequest, Principal principal) {
        String username = principal.getName(); // Obtiene el usuario autenticado
        String newPassword = passwordRequest.get("newPassword");

        if (newPassword == null || newPassword.isEmpty()) {
            return ResponseEntity.badRequest().body("La nueva contraseña no puede estar vacía.");
        }

        boolean isUpdated = employeeService.changePassword(username, newPassword);
        if (isUpdated) {
            return ResponseEntity.ok("Contraseña actualizada correctamente.");
        } else {
            return ResponseEntity.status(400).body("Error al actualizar la contraseña.");
        }
    }
}