package com.med.controller;

import com.med.model.Invoice;
import com.med.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-purshase")
public class InvoiceController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/invoices")
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();


    }

    @PostMapping("/invoice")
    public Invoice postInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


    @GetMapping("/invoice/edit/{id}")
    public Invoice getOne(@PathVariable("id") Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.get() != null) {
            return invoice.get();
        }
        return null;
    }

    @PostMapping("/invoice/update/{id}")
    public Invoice updateInvoice(@PathVariable("id") Long id, Invoice invoice) {
        Optional<Invoice> invoiceLoaded = invoiceRepository.findById(id);
        if (invoiceLoaded != null) {
            return invoiceRepository.save(invoice);
        }

        return null;
    }

    @DeleteMapping("/invoice/delete/{id}")
    public ResponseEntity<Invoice> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        if (invoice != null) {
            invoiceRepository.delete(invoice.get());
            return new ResponseEntity<Invoice>(HttpStatus.OK);
        }
        return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
    }

    public InvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


}
