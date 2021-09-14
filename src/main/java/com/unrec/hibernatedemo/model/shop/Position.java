package com.unrec.hibernatedemo.model.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSITIONS")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String product;

  @Column
  private int quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  private Order order;

  public Position() {
  }

  public Position(String product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Position(String product, int quantity, Order order) {
    this.product = product;
    this.quantity = quantity;
    this.order = order;
  }

  public Long getId() {
    return id;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
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
    Position other = (Position) obj;
    if (id == null) {
      return false;
    } else {
      return id.equals(other.id);
    }
  }
}