package com.wirehec.microservice_Supplier.Repository;

import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrderEntity, Long> {
}
