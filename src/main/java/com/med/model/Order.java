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
public class Order implements Serializable {
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
}
