package com.wirehec.microservice_Login.Repository;

import com.wirehec.microservice_Login.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByUsername(String username);

    @Query("select u from EmployeeEntity u where u.username = ?1")
    Optional<EmployeeEntity> getName(String username);
}
