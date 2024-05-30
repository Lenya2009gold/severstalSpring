package com.example.ruit_supply.Controller;

import com.example.ruit_supply.Entity.Delivery;
import com.example.ruit_supply.Service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@Slf4j
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.createDelivery(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }
}
