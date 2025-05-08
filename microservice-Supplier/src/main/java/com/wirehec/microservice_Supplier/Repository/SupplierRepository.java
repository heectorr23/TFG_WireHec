package com.wirehec.microservice_Supplier.Repository;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}
