package com.gearhead.busyboard.company.entity;

import com.gearhead.busyboard.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column(name="subscription_plan")
    private String subscriptionPlan;

    @Column(name ="created_at")
    private Instant createdAt;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public List<User> getUsers() {
        return users;
    }

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<User> users;
}
