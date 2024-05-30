package com.example.ruit_supply.Service;

import com.example.ruit_supply.Entity.Supplier;
import com.example.ruit_supply.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers()
    {
        return supplierRepository.findAll();
    }

    public Supplier createSupplier(Supplier supplier)
    {
        return supplierRepository.save(supplier);
    }
    @Transactional
    public Supplier updateSupplier(Long id, Supplier supplierNew)
    {
        Supplier supplier = supplierRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Supplier not found"));
        supplier.setName(supplierNew.getName());
        supplier.setContactInfo(supplierNew.getContactInfo());
        return supplierRepository.save(supplier);
    }

}
