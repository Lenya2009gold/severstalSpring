package com.example.ruit_supply.Service;

import com.example.ruit_supply.Entity.Delivery;
import com.example.ruit_supply.Entity.DeliveryDetail;
import com.example.ruit_supply.Entity.Price;
import com.example.ruit_supply.Repository.DeliveryDetailRepository;
import com.example.ruit_supply.Repository.DeliveryRepository;
import com.example.ruit_supply.Repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Transactional
    public Delivery createDelivery(Delivery delivery) {
        Long idsup=delivery.getSupplier().getId();
        log.info("Создание новой поставки для поставщика {}", idsup);
        // Соберем ID всех продуктов в поставке
        Set<Long> productIds = delivery.getDeliveryDetails().stream()
                .map(detail -> detail.getProduct().getId())
                .collect(Collectors.toSet());

        // Получаем все цены одним запросом
        List<Price> prices = priceRepository.findAllByProductIdInAndSupplierId(productIds, idsup);
        Map<Long, Double> priceMap = prices.stream()
                .collect(Collectors.toMap(price -> price.getProduct().getId(), Price::getPrice));

        for (DeliveryDetail detail : delivery.getDeliveryDetails()) {
            Double price = priceMap.get(detail.getProduct().getId());
            if (price == null) {
                log.error("Цена для продукта с ID {} не найдена.", detail.getProduct().getId());
                throw new IllegalArgumentException("Цена для продукта с ID " + detail.getProduct().getId() + " не найдена.");
            }
            detail.setPrice(price);
            detail.setTotalCost(detail.getQuantity() * price);
            detail.setDelivery(delivery);
        }
        return deliveryRepository.save(delivery);

    }
    public List<Delivery> getAllDeliveries()
    {
        List<Delivery> deliveries = deliveryRepository.findAll();
        for (Delivery delivery : deliveries) {
            delivery.getDeliveryDetails().forEach(detail -> {
                detail.getProduct().getName(); // Инициализация ленивого поля
                detail.getProduct().getType(); // Инициализация ленивого поля
            });
        }
        return deliveries;
    }

}
