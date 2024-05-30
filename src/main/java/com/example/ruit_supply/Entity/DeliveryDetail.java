package com.example.ruit_supply.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="delivery_details")
public class DeliveryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonBackReference
    Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    Integer quantity;

    Double price;
    Double totalCost;
}
