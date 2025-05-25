package com.wirehec.microservice_Login.Security.Filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wirehec.microservice_Login.Entity.EmployeeEntity;
import com.wirehec.microservice_Login.Security.Jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        EmployeeEntity employeeEntity = null;
        String username = "";
        String password = "";

        try {
            employeeEntity = new ObjectMapper().readValue(request.getInputStream(), EmployeeEntity.class);

            if (employeeEntity != null) {
                username = employeeEntity.getUsername();
                password = employeeEntity.getPasswordEmpleado();
            }

            log.info("Username recibido: " + username);
            log.info("Password recibido: " + password);

            if (username == null || username.isEmpty()) {
                throw new RuntimeException("El campo 'username' es null o está vacío.");
            }

            if (password == null || password.isEmpty()) {
                throw new RuntimeException("El campo 'passwordEmpleado' es null o está vacío.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la solicitud de autenticación: " + e.getMessage(), e);
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
        String username = user.getUsername();

        if (username == null || username.isEmpty()) {
            throw new RuntimeException("El username del usuario autenticado no puede ser null o vacío.");
        }

        String token = jwtUtils.generateAccesToken(user);

        response.addHeader("Authorization", token);

        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("Message", "User successfully authenticated");
        httpResponse.put("Username", username);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}