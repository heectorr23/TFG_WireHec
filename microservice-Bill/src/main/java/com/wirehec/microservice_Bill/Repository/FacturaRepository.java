package com.wirehec.microservice_Bill.Repository;

import com.wirehec.microservice_Bill.Entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {

    @Override
    List<FacturaEntity> findAll();

    @Override
    <S extends FacturaEntity> S save(S entity);
}
