package com.example.avaliacao20260520.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioRequestDTO {

    @NotBlank(message = "Informe um nome")
    private String nome;

    @NotBlank(message = "Informe um CPF")
    private String cpf;

    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "Informe um contato")
    private String telefone;

    @NotBlank(message = "Informe o setor")
    private String setor;

    @NotNull(message = "Informe o salário")
    private double salario;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
    }

    public @NotBlank(message = "Informe um nome") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Informe um nome") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Informe um CPF") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "Informe um CPF") String cpf) {
        this.cpf = cpf;
    }

    public @Email(message = "Informe um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Informe um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Informe um contato") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Informe um contato") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Informe o setor") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "Informe o setor") String setor) {
        this.setor = setor;
    }

    @NotNull(message = "Informe o salário")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "Informe o salário") double salario) {
        this.salario = salario;
    }
}
