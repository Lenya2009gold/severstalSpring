package com.example.ruit_supply.Service;

import com.example.ruit_supply.Entity.Price;
import com.example.ruit_supply.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;


    public List<Price> getAllPrices()
    {
        return priceRepository.findAll();
    }
    public Price createPrice(Price price)
    {
        return priceRepository.save(price);
    }
    @Transactional
    public Price updatePrice(Long id, Price priceDetails) {
        Price price = priceRepository.findById(id).orElseThrow(() -> new RuntimeException("Price not found"));
        price.setProduct(priceDetails.getProduct());
        price.setSupplier(priceDetails.getSupplier());
        price.setPrice(priceDetails.getPrice());
        return priceRepository.save(price);
    }

}
