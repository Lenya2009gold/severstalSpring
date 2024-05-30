package com.example.ruit_supply.Service;

import com.example.ruit_supply.Entity.DeliveryDetail;
import com.example.ruit_supply.Entity.ReportEntry;
import com.example.ruit_supply.Repository.DeliveryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private DeliveryDetailRepository deliveryDetailRepository;




    public List<ReportEntry> generateReport(LocalDate strartDate, LocalDate endDate)
    {
        List<DeliveryDetail> details = deliveryDetailRepository.findByDeliveryDateBetween(strartDate, endDate);
        return details.stream()
                .collect(Collectors.groupingBy(detail -> detail.getDelivery().getSupplier().getName()))
                .entrySet().stream()
                .map(entry -> {
                    String supplierName = entry.getKey();
                    List<DeliveryDetail> supplierDetails = entry.getValue();
                    double totalWeight = supplierDetails.stream().mapToDouble(DeliveryDetail::getQuantity).sum();
                    double totalCost = supplierDetails.stream().mapToDouble(DeliveryDetail::getTotalCost).sum();
                    return new ReportEntry(supplierName, totalWeight, totalCost);
                })
                .collect(Collectors.toList());

    }

}
