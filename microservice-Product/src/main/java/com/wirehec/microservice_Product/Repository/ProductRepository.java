package com.wirehec.microservice_Product.Repository;

import com.wirehec.microservice_Product.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    List<ProductEntity> findAll();

    @Override
    <S extends ProductEntity> S save(S entity);
}
