package com.wirehec.microservice_Login.Repository;

import com.wirehec.microservice_Login.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
