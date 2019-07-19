package com.med.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String tele;
    private String email;
    private String address;
    private String ice;

    public Customer(String name, String tele, String email, String address, String ice) {
        this.name = name;
        this.tele = tele;
        this.email = email;
        this.address = address;
        this.ice = ice;
    }
}
