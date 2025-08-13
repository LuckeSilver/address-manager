package com.example.addressmanager.controller;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
        try {
            Address savedAddress = addressService.createAddress(address);
            return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id,
                                                 @Valid @RequestBody Address addressDetails) {
        System.out.println("=== UPDATE REQUEST ===");
        System.out.println("Path ID: " + id);
        System.out.println("Request Body: " + addressDetails.toString());

        try {
            Address updatedAddress = addressService.updateAddress(id, addressDetails);
            if (updatedAddress == null) {
                System.out.println("ID não encontrado: " + id);
                return ResponseEntity.notFound().build();
            }
            System.out.println("Update successful: " + updatedAddress);
            return ResponseEntity.ok(updatedAddress);
        } catch (Exception e) {
            System.out.println("Update error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        try {
            addressService.deleteAddress(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}