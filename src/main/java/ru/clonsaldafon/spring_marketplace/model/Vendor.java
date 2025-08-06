package ru.clonsaldafon.spring_marketplace.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 16, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "vendor")
    private List<Product> products;

    public Vendor(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Vendor() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
