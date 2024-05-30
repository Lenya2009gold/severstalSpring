package com.example.ruit_supply.Repository;

import com.example.ruit_supply.Entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {
    Price findByProductIdAndSupplierId(Long productId, Long supplierId);
    List<Price> findAllByProductIdInAndSupplierId(Set<Long> productIds, Long supplierId);
}
