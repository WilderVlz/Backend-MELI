package com.nocountry.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_cart")
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_cart_id")
    private Integer productCartId;

    @ManyToOne
    @JoinColumn(name = "account_uuid")
    private Account userBuyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public ProductCart() {}

    public Integer getProductCartId() {
        return productCartId;
    }

    public void setProductCartId(Integer productCartId) {
        this.productCartId = productCartId;
    }

    public Account getUserBuyer() {
        return userBuyer;
    }

    public void setUserBuyer(Account userBuyer) {
        this.userBuyer = userBuyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
