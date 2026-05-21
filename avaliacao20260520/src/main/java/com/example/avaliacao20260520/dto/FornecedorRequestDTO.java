package com.example.avaliacao20260520.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FornecedorRequestDTO {

    @NotBlank(message = "Informe um nome")
    private String nome;

    @NotBlank(message = "Informe um CNPJ")
    private String cnpj;

    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "Informe um Contato")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe um nome") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe um nome") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe um CNPJ") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "Informe um CNPJ") String cnpj) {
        this.cnpj = cnpj;
    }

    public @Email(message = "Informe um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Informe um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Informe um Contato") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Informe um Contato") String telefone) {
        this.telefone = telefone;
    }
}



