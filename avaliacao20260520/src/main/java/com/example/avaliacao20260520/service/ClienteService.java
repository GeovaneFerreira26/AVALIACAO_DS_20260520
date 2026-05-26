package com.example.avaliacao20260520.service;

import com.example.avaliacao20260520.dto.ClienteRequestDTO;
import com.example.avaliacao20260520.dto.ClienteResponseDTO;
import com.example.avaliacao20260520.model.ClienteModel;
import com.example.avaliacao20260520.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ClienteRepository repository;

    public List<ClienteResponseDTO>listarClientes(){
        return repository.findAll().stream().map(cliente ->
                new ClienteResponseDTO(cliente.getNome(), cliente.getDataNascimento(), cliente.getEmail())).toList();
    }

    public ClienteModel salvarClientes(ClienteRequestDTO saveClientesDTO) {
        if (repository.findByEmail(saveClientesDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já Cadastrado ❌");
        }
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(saveClientesDTO.getNome());
        novoCliente.setCpf(saveClientesDTO.getCpf());
        novoCliente.setDataNascimento(saveClientesDTO.getDataNascimento());
        novoCliente.setEmail(saveClientesDTO.getEmail());
        novoCliente.setSenha(passwordEncoder.encode(saveClientesDTO.getSenha()));

        return repository.save(novoCliente);
    }

    public ClienteModel atualizarCliente(Long id, ClienteRequestDTO updateClienteDTO){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cadastro não localizado ❌");
        }
        ClienteModel clienteUpdate = repository.findById(id).get();

        clienteUpdate.setNome(updateClienteDTO.getNome());
        clienteUpdate.setCpf(updateClienteDTO.getCpf());
        clienteUpdate.setDataNascimento(updateClienteDTO.getDataNascimento());
        clienteUpdate.setEmail(updateClienteDTO.getEmail());
        clienteUpdate.setSenha(passwordEncoder.encode(updateClienteDTO.getSenha()));

        return repository.save(clienteUpdate);
    }

    public void deletarCliente(Long id){
        if (!repository.existsById(id)){
            throw  new RuntimeException("Cadastro não localizado ❌");
        }
        repository.deleteById(id);
    }

}
