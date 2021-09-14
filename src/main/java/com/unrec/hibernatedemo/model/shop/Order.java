package com.unrec.hibernatedemo.model.shop;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<Position> positions = new HashSet<>();

    public Order() {
    }

    public Order(String customer) {
        this.customer = customer;
    }

    public Order(String customer, Set<Position> positions) {
        this.customer = customer;
        this.positions = positions;
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Order other = (Order) obj;
        if (id == null) {
            return false;
        } else {
            return id.equals(other.id);
        }
    }

    @Override
    public String toString() {
        return "Order [customer=" + customer + ", id=" + id + "]";
    }
}