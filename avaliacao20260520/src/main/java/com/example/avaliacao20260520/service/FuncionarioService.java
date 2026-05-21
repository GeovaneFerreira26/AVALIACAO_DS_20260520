package com.example.avaliacao20260520.service;

import com.example.avaliacao20260520.dto.FuncionarioRequestDTO;
import com.example.avaliacao20260520.dto.FuncionarioResponseDTO;
import com.example.avaliacao20260520.model.FuncionarioModel;
import com.example.avaliacao20260520.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioResponseDTO>listarFunc(){
        return  repository.findAll().stream().map(funcionario ->
                new FuncionarioResponseDTO(funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getTelefone(),
                funcionario.getSetor(),
                funcionario.getSalario())).toList();
    }
    public FuncionarioModel salvarFunc(FuncionarioRequestDTO salvarFuncDTO){
        if (repository.findByEmail(salvarFuncDTO.getEmail()).isPresent()){
            throw new RuntimeException("Funcionário já Cadastrado ❌");
        }
        FuncionarioModel novoFunc = new FuncionarioModel();
        novoFunc.setNome(salvarFuncDTO.getNome());
        novoFunc.setCpf(salvarFuncDTO.getCpf());
        novoFunc.setEmail(salvarFuncDTO.getEmail());
        novoFunc.setTelefone(salvarFuncDTO.getTelefone());
        novoFunc.setSetor(salvarFuncDTO.getSetor());
        novoFunc.setSalario(salvarFuncDTO.getSalario());

        return repository.save(novoFunc);
    }

    public FuncionarioModel atualizarFunc(Long id,FuncionarioRequestDTO updateFuncDTO){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cadastro não localizado ❌");
        }
        FuncionarioModel funcionarioUpdate = new FuncionarioModel();
        funcionarioUpdate.setId(id);
        funcionarioUpdate.setNome(updateFuncDTO.getNome());
        funcionarioUpdate.setCpf(updateFuncDTO.getCpf());
        funcionarioUpdate.setEmail(updateFuncDTO.getEmail());
        funcionarioUpdate.setTelefone(updateFuncDTO.getTelefone());
        funcionarioUpdate.setSetor(updateFuncDTO.getSetor());
        funcionarioUpdate.setSalario(updateFuncDTO.getSalario());

        return repository.save(funcionarioUpdate);
    }

    public void deletarFuncionario(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastro não localizado ❌");
        }
        repository.deleteById(id);
    }
}
