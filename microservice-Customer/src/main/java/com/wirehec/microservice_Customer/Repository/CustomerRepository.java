package com.wirehec.microservice_Customer.Repository;

import com.wirehec.microservice_Customer.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Override
    List<CustomerEntity> findAll();

    @Override
    <S extends CustomerEntity> S save(S entity);
}
