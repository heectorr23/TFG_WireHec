package com.wirehec.microservice_Contability.Service.Inter;

import com.wirehec.microservice_Contability.Entity.ContabilityEntity;

import java.util.List;

public interface IContabilityService {

    List<ContabilityEntity> findAll();

    ContabilityEntity saveContability(ContabilityEntity contabilityEntity);

    ContabilityEntity updateContability(Long id, ContabilityEntity contabilityEntity);

    void deleteContability(Long id);
}
