package com.wirehec.microservice_Supplier.Repository;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    @Override
    List<SupplierEntity> findAll();

    @Override
    <S extends SupplierEntity> S save(S entity);
}
