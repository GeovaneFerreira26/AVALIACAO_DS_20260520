package com.example.avaliacao20260520.service;

import com.example.avaliacao20260520.dto.FornecedorResponseDTO;
import com.example.avaliacao20260520.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorResponseDTO>listarFornecedores(){
        
    }
}
