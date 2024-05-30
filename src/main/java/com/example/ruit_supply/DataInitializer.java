package com.example.ruit_supply;

import com.example.ruit_supply.Entity.*;
import com.example.ruit_supply.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryDetailRepository deliveryDetailRepository;

    private Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        if (supplierRepository.count() == 0) {
            initializeSuppliers();
        }

        if (productRepository.count() == 0) {
            initializeProducts();
        }

        if (priceRepository.count() == 0) {
            initializePrices();
        }

        if (deliveryRepository.count() == 0) {
            initializeDeliveries();
        }
    }

    private void initializeSuppliers() {
        List<String> supplierNames = Arrays.asList("Supplier A", "Supplier B", "Supplier C");
        List<String> contacts = Arrays.asList("Contact Info A", "Contact Info B", "Contact Info C");

        for (int i = 0; i < supplierNames.size(); i++) {
            Supplier supplier = new Supplier();
            supplier.setName(supplierNames.get(i));
            supplier.setContactInfo(contacts.get(i));
            supplierRepository.save(supplier);
        }
    }

    private void initializeProducts() {
        List<String> productNames = Arrays.asList("Red Apple", "Green Apple", "Yellow Banana");
        List<String> types = Arrays.asList("Apple", "Apple", "Banana");

        for (int i = 0; i < productNames.size(); i++) {
            Product product = new Product();
            product.setName(productNames.get(i));
            product.setType(types.get(i));
            productRepository.save(product);
        }
    }

    private void initializePrices() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<Product> products = productRepository.findAll();

        for (Supplier supplier : suppliers) {
            for (Product product : products) {
                Price price = new Price();
                price.setProduct(product);
                price.setSupplier(supplier);
                price.setPrice(1.5 + 0.5 * random.nextInt(5)); // случайные цены от 1.5 до 3.5
                priceRepository.save(price);
            }
        }
    }

    private void initializeDeliveries() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<Product> products = productRepository.findAll();
        LocalDate startDate = LocalDate.of(2024, 5, 29);

        for (int i = 0; i < 5; i++) {
            Delivery delivery = new Delivery();
            delivery.setSupplier(suppliers.get(random.nextInt(suppliers.size())));
            delivery.setDate(startDate.plusDays(i));

            for (Product product : products) {
                DeliveryDetail detail = new DeliveryDetail();
                detail.setProduct(product);
                detail.setQuantity(100 + random.nextInt(100));
                detail.setPrice(2.5);
                detail.setTotalCost(detail.getQuantity() * detail.getPrice());
                detail.setDelivery(delivery);

                delivery.getDeliveryDetails().add(detail);
            }
            deliveryRepository.save(delivery);
        }
    }
}
