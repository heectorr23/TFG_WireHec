package com.wirehec.microservice_Employee.Repository;

import com.wirehec.microservice_Employee.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Override
    List<EmployeeEntity> findAll();

    @Override
    <S extends EmployeeEntity> S save(S entity);


}
