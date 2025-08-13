package com.example.addressmanager.service;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address updateAddress(Long id, Address addressDetails) {
        return addressRepository.findById(id)
                .map(address -> {
                    address.setNome(addressDetails.getNome());
                    address.setCpf(addressDetails.getCpf());
                    address.setCep(addressDetails.getCep());
                    address.setEndereco(addressDetails.getEndereco());
                    return addressRepository.save(address);
                })
                .orElse(null); // Retorna null se não encontrar
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Endereço não encontrado com id: " + id);
        }
        addressRepository.deleteById(id);
    }
}