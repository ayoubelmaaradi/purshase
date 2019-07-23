package com.med.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderTo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String status;
    @OneToMany
    private List<OrderItem> orderItems;
    private Date dateOrdering;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderTo(String reference, String status, List<OrderItem> orderItems, Date dateOrdering) {
        this.reference = reference;
        this.status = status;
        this.orderItems = orderItems;
        this.dateOrdering = dateOrdering;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getDateOrdering() {
        return dateOrdering;
    }

    public void setDateOrdering(Date dateOrdering) {
        this.dateOrdering = dateOrdering;
    }
}
