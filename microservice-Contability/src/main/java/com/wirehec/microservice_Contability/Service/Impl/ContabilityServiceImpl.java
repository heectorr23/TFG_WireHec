package com.wirehec.microservice_Contability.Service.Impl;

import com.wirehec.microservice_Contability.Entity.ContabilityEntity;
import com.wirehec.microservice_Contability.Repository.ContabilityRepository;
import com.wirehec.microservice_Contability.Service.Inter.IContabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContabilityServiceImpl implements IContabilityService {
    @Autowired
    private ContabilityRepository contabilityRepository;

    @Override
    public List<ContabilityEntity> findAll() {
        return contabilityRepository.findAll();
    }
    @Override
    public ContabilityEntity saveContability(ContabilityEntity contabilityEntity) {
        return contabilityRepository.save(contabilityEntity);
    }
    @Override
    public ContabilityEntity updateContability(Long id, ContabilityEntity contabilityEntity) {
        ContabilityEntity existingContability = contabilityRepository.findById(id).orElseThrow();
        existingContability.setIdContabilidad(contabilityEntity.getIdContabilidad());
        existingContability.setPresupuestomensual(contabilityEntity.getPresupuestomensual());
        existingContability.setBeneficio(contabilityEntity.getBeneficio());
        existingContability.setGasto(contabilityEntity.getGasto());
        return contabilityRepository.save(existingContability);
    }

    @Override
    public void deleteContability(Long id) {
        contabilityRepository.deleteById(id);
    }
}
