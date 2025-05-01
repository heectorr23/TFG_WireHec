package com.wirehec.microservice_Supplier.Repository;


import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierDetailRepository extends JpaRepository<SupplierDetailEntity, Long> {

    @Override
    List<SupplierDetailEntity> findAll();

    @Override
    <S extends SupplierDetailEntity> S save(S entity);
}
