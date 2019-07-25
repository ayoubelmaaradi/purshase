package com.med.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne//plusieur facture pr un seule customer
    private Customer customer;
    @OneToOne
    private OrderTo order;
    Date dateInvoice=new Date();

    public Invoice(Customer customer, OrderTo order, Date dateInvoice) {
        this.customer = customer;
        this.order = order;
        this.dateInvoice = dateInvoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderTo getOrder() {
        return order;
    }

    public void setOrder(OrderTo order) {
        this.order = order;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }
}
