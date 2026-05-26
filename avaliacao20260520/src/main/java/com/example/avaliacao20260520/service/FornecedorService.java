package com.example.avaliacao20260520.service;

import com.example.avaliacao20260520.dto.FornecedorRequestDTO;
import com.example.avaliacao20260520.dto.FornecedorResponseDTO;
import com.example.avaliacao20260520.model.FornecedorModel;
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
        return repository.findAll().stream().map(fornecedor -> new FornecedorResponseDTO(fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getTelefone())).toList();
        
    }
    public FornecedorModel salvarFornecedor(FornecedorRequestDTO salvarDTO){
        if (repository.findByEmail(salvarDTO.getEmail()).isPresent()){
            throw new RuntimeException("Fornecedor já cadastrado");
        }
        FornecedorModel novoFornecedor = new FornecedorModel();
        novoFornecedor.setNome(salvarDTO.getNome());
        novoFornecedor.setCnpj(salvarDTO.getCnpj());
        novoFornecedor.setEmail(salvarDTO.getEmail());
        novoFornecedor.setTelefone(salvarDTO.getTelefone());

        return repository.save(novoFornecedor);
    }

    public FornecedorModel atualizarFornecedor(Long id, FornecedorRequestDTO atualizarDTO){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cadastro não localizado");
        }
        FornecedorModel novoFornecedor = repository.findById(id).get();
        novoFornecedor.setNome(atualizarDTO.getNome());
        novoFornecedor.setCnpj(atualizarDTO.getCnpj());
        novoFornecedor.setEmail(atualizarDTO.getEmail());
        novoFornecedor.setTelefone(atualizarDTO.getTelefone());

        return repository.save(novoFornecedor);
    }

    public void deletarFornecedor(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastro não localizado");
        }
        repository.deleteById(id);
    }
}
