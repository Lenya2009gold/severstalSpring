package com.example.ruit_supply.Repository;

import com.example.ruit_supply.Entity.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail, Long> {
    List<DeliveryDetail> findByDeliveryDateBetween(LocalDate startDate, LocalDate endDate);
}
