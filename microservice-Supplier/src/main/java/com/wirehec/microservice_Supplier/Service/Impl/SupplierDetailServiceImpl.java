package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Entity.SupplierDetailEntity;
import com.wirehec.microservice_Supplier.Repository.SupplierDetailRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierDetailServiceImpl implements ISupplierDetailService {

    @Autowired
    private SupplierDetailRepository supplierDetailRepository;

    @Override
    public List<SupplierDetailEntity> findAll() {
        return supplierDetailRepository.findAll();
    }
    @Override
    public SupplierDetailEntity saveSupplierDetail(SupplierDetailEntity supplierDetailEntity) {
        return supplierDetailRepository.save(supplierDetailEntity);
    }

    public SupplierDetailEntity updateSupplierDetail(Long id, SupplierDetailEntity supplierDetailEntity) {
        SupplierDetailEntity existingSupplierDetail = supplierDetailRepository.findById(id).orElseThrow();
        existingSupplierDetail.setIdDetalleProveedor(supplierDetailEntity.getIdDetalleProveedor());
        existingSupplierDetail.setSupplierEntity(supplierDetailEntity.getSupplierEntity());
        existingSupplierDetail.setSupplierOrderEntities(supplierDetailEntity.getSupplierOrderEntities());
        return supplierDetailRepository.save(existingSupplierDetail);
    }

    @Override
    public void deleteSupplierDetail(Long id) {
        supplierDetailRepository.deleteById(id);
    }

    @Override
    public List<SupplierDetailEntity> findByIdProduct(Long idProduct) {
        return supplierDetailRepository.findByIdProduct(idProduct);
    }
}
