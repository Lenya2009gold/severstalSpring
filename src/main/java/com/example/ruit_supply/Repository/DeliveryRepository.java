package com.example.ruit_supply.Repository;

import com.example.ruit_supply.Entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
