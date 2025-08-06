package ru.clonsaldafon.spring_marketplace.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Column(nullable = false)
    private Byte stars;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Feedback(String text, Byte stars, User user, Product product) {
        this.text = text;
        this.stars = stars;
        this.createdAt = ZonedDateTime.now();
        this.user = user;
        this.product = product;
    }

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Byte getStars() {
        return stars;
    }

    public void setStars(Byte stars) {
        this.stars = stars;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }
}
