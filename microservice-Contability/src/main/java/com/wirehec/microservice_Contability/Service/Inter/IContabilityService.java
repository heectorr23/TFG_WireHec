package com.wirehec.microservice_Contability.Service.Inter;

import com.wirehec.microservice_Contability.Entity.ContabilityEntity;

import java.util.List;

public interface IContabilityService {

    List<ContabilityEntity> findAll();

    ContabilityEntity saveContability(ContabilityEntity contabilityEntity);

    void deleteContability(Long id);
}
