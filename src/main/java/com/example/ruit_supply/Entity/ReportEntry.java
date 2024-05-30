package com.example.ruit_supply.Entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntry {
     private String supplierName;
     private double totalWeight;
     private double totalCost;

    @Override
    public String toString() {
        return "ReportEntry{" +
                "supplierName='" + supplierName + '\'' +
                ", totalWeight=" + totalWeight +
                ", totalCost=" + totalCost +
                '}';
    }

}
