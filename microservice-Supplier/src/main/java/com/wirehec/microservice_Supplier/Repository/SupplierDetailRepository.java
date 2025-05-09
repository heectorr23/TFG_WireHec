package com.wirehec.microservice_Supplier.Repository;


import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

public interface SupplierDetailRepository extends JpaRepository<SupplierDetailEntity, Long> {

    @Override
    List<SupplierDetailEntity> findAll();

    @Override
    <S extends SupplierDetailEntity> S save(S entity);
public interface SupplierDetailRepository extends JpaRepository<SupplierDetailEntity, Long> {

    // Méthodo para encontrar productos por ID de proveedor
    @Query("SELECT d FROM SupplierDetailEntity d WHERE d.idProduct = :idProduct")
    List<SupplierDetailEntity> findByIdProduct(Long idProduct);
}
