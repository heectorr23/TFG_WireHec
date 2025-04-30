package com.wirehec.microservice_Supplier.Service.Impl;

import com.wirehec.microservice_Supplier.Entity.SupplierOrderEntity;
import com.wirehec.microservice_Supplier.Repository.SupplierOrderRepository;
import com.wirehec.microservice_Supplier.Service.Inter.ISupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierOrderServiceImpl implements ISupplierOrderService {

    @Autowired
    private SupplierOrderRepository supplierOrderRepository;

    @Override
    public List<SupplierOrderEntity> findAll() {
        return supplierOrderRepository.findAll();
    }
    @Override
    public SupplierOrderEntity saveSupplierOrder(SupplierOrderEntity supplierOrderEntity) {
        return supplierOrderRepository.save(supplierOrderEntity);
    }

    public SupplierOrderEntity updateSupplierOrder(Long id, SupplierOrderEntity supplierOrderEntity) {
        SupplierOrderEntity existingSupplierOrder = supplierOrderRepository.findById(id).orElseThrow();
        existingSupplierOrder.setIdPedidoProveedor(supplierOrderEntity.getIdPedidoProveedor());
        return supplierOrderRepository.save(existingSupplierOrder);
    }

    @Override
    public void deleteSupplierOrder(Long id) {
        supplierOrderRepository.deleteById(id);
    }
}
