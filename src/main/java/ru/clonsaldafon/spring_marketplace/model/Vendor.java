package ru.clonsaldafon.spring_marketplace.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("VENDOR")
public class Vendor extends UserBase {

    @OneToMany(mappedBy = "vendor")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
