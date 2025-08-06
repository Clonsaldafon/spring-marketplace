package ru.clonsaldafon.spring_marketplace.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("USER")
public class User extends UserBase {

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
