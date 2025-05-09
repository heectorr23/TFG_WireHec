package com.wirehec.microservice_Supplier.Repository;

import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrderEntity, Long> {
    @Override
    List<SupplierOrderEntity> findAll();

    @Override
    <S extends SupplierOrderEntity> S save(S entity);
}
