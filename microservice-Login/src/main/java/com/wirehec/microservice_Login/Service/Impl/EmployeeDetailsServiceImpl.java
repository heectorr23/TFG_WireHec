package com.wirehec.microservice_Login.Service.Impl;

import com.wirehec.microservice_Login.Entity.EmployeeEntity;
import com.wirehec.microservice_Login.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeEntity employeeEntity = employeeRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("El Usuario" + username + "no existe"));

        Collection<GrantedAuthority> authorities = employeeEntity.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
            .collect(Collectors.toList());

        return new User(employeeEntity.getUsername(),
                employeeEntity.getPasswordEmpleado(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
