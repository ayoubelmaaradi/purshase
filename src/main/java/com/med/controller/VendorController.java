package com.med.controller;


import com.med.model.Product;
import com.med.model.Vendor;
import com.med.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-purshase")
public class VendorController {


    @Autowired
    private VendorRepository vendorRepository;

    @GetMapping("/vendors")
    public List<Vendor> getAll() {
        return vendorRepository.findAll();
    }

    @PostMapping("/vendor")

    public Vendor postVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }


    @GetMapping("/vendor/edit/{id}")
    public Vendor getOne(@PathVariable("id") Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if (vendor.get() != null) {
            return vendor.get();
        }
        return null;
    }

    @PutMapping("/vendor/update/{id}")
    public Vendor updateVendor(@PathVariable("id") Long id, Vendor vendor) {
        Optional<Vendor> vendorLoaded = vendorRepository.findById(id);
        if (vendorLoaded != null) {
            return vendorRepository.save(vendor);
        }

        return null;
    }

    @DeleteMapping("/vendor/delete/{id}")
    public ResponseEntity<Vendor> deleteVendor(@PathVariable("id") Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);

        if (vendor != null) {
            vendorRepository.delete(vendor.get());
            return new ResponseEntity<Vendor>(HttpStatus.OK);
        }
        return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
    }
}
