package com.wirehec.microservice_Product.Repository;

import com.wirehec.microservice_Product.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
