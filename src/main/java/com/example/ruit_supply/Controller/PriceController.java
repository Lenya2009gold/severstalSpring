package com.example.ruit_supply.Controller;

import com.example.ruit_supply.Entity.Price;
import com.example.ruit_supply.Service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
@Slf4j

public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @PostMapping
    public Price createPrice(@RequestBody Price price) {
        return priceService.createPrice(price);
    }

    @PutMapping("/{id}")
    public Price updatePrice(@PathVariable Long id, @RequestBody Price price) {
        return priceService.updatePrice(id, price);
    }

}
