package com.example.avaliacao20260520.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteRequestDTO {

    @NotBlank(message = "Informe um nome")
    private String nome;

    @NotBlank(message = "Informe um CPF")
    private String cpf;

    @NotBlank(message = "Informe a Data de Nascimento")
    private String dataNascimento;

    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "Cadastre uma Senha")
    private String senha;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf, String dataNascimento, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
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

    public @NotBlank(message = "Informe a Data de Nascimento") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank(message = "Informe a Data de Nascimento") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @Email(message = "Informe um email válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Informe um email válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Cadastre uma Senha") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Cadastre uma Senha") String senha) {
        this.senha = senha;
    }
}
