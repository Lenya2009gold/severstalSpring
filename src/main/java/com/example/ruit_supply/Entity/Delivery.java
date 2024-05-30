package com.example.ruit_supply.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="deliveries")
public class Delivery  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    @JsonBackReference
    Supplier supplier;

    LocalDate date;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<DeliveryDetail> deliveryDetails= new ArrayList<>();
}
