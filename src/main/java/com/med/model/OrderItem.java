package com.med.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qte;
    @OneToOne
    private Product product;
    @ManyToOne
    private Order order;

    public OrderItem(int qte, Product product, Order order) {
        this.qte = qte;
        this.product = product;
        this.order = order;
    }


    public void setOrder(Order order) {
        this.order=order;
    }
}

