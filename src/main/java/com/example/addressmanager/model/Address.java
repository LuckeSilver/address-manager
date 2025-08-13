package com.example.addressmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Column(nullable = false, length = 14)
    private String cpf;

    @NotBlank(message = "CEP é obrigatório")
    @Column(nullable = false, length = 9)
    private String cep;

    @NotBlank(message = "Endereço é obrigatório")
    @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres")
    @Column(nullable = false, length = 200)
    private String endereco;

    // Construtor padrão exigido pelo JPA
    public Address() {}

    // Construtor com campos obrigatórios
    public Address(String nome, String cpf, String cep, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
    }

    // Getters e Setters (poderia usar Lombok @Data para simplificar ainda mais)
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // toString() simplificado para logs
    @Override
    public String toString() {
        return "Address{id=" + id + ", nome='" + nome + "', cpf='" + cpf + "'}";
    }
}