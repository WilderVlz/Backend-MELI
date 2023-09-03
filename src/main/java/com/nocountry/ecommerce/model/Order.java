package com.nocountry.ecommerce.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "account_uuid", referencedColumnName = "account_uuid")
    private Account clientShopper;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCart> productCarts;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "total")
    private Double total;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "description")
    private String description;

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Account getClientShopper() {
        return clientShopper;
    }

    public void setClientShopper(Account clientShopper) {
        this.clientShopper = clientShopper;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<ProductCart> getProductCarts() {
        return productCarts;
    }

    public void setProductCarts(List<ProductCart> productCarts) {
        this.productCarts = productCarts;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
