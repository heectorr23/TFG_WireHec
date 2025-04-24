package com.wirehec.microservice_Contability.Repository;

import com.wirehec.microservice_Contability.Entity.ContabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContabilityRepository extends JpaRepository<ContabilityEntity, Long> {

}
