package com.example.avaliacao20260520.controller;

import com.example.avaliacao20260520.dto.ClienteRequestDTO;
import com.example.avaliacao20260520.dto.ClienteResponseDTO;
import com.example.avaliacao20260520.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    public ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarClientes());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO clienteCadastroDTO){
        service.salvarClientes(clienteCadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "CADASTRADO COM SUCESSO ✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarCadastroClientes(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO clienteAtualizrDTO){
        service.atualizarCliente(id, clienteAtualizrDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO ATUALIZADO COM SUCESSO✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO DELETADO COM SUCESSO ✅" ));
    }
}
