package com.example.addressmanager.repository;

import com.example.addressmanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Mantido para verificação de CPF único
    boolean existsByCpf(String cpf);
}