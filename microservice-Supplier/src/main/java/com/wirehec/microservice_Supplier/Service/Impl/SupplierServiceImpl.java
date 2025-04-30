package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Entity.SupplierEntity;
import com.wirehec.microservice_Supplier.Repository.SupplierRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierEntity> findAll() {
        return supplierRepository.findAll();
    }
    @Override
    public SupplierEntity saveSupplier(SupplierEntity supplierEntity) {
        return supplierRepository.save(supplierEntity);
    }

    public SupplierEntity updateSupplier(Long id, SupplierEntity supplierEntity) {
        SupplierEntity existingSupplier = supplierRepository.findById(id).orElseThrow();
        existingSupplier.setIdProveedor(supplierEntity.getIdProveedor());
        existingSupplier.setNombreProveedor(supplierEntity.getNombreProveedor());
        existingSupplier.setCifProveedor(supplierEntity.getCifProveedor());
        existingSupplier.setEmailProveedor(supplierEntity.getEmailProveedor());
        existingSupplier.setCategoriaProveedor(supplierEntity.getCategoriaProveedor());
        existingSupplier.setProductoProveedor(supplierEntity.getProductoProveedor());
        return supplierRepository.save(existingSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

}
