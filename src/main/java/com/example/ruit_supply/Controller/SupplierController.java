package com.example.ruit_supply.Controller;

import com.example.ruit_supply.Entity.Supplier;
import com.example.ruit_supply.Service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;



    @GetMapping
    public List<Supplier> getAllSuppliers()
    {
        return supplierService.getAllSuppliers();
    }


    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier)
    {
        return supplierService.createSupplier(supplier);
    }
    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier)
    {
        return supplierService.updateSupplier(id,supplier);
    }

}

