package com.example.avaliacao20260520.controller;


import com.example.avaliacao20260520.dto.FornecedorRequestDTO;
import com.example.avaliacao20260520.dto.FornecedorResponseDTO;
import com.example.avaliacao20260520.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarFornecedores(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarFornecedores());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>>salvarFornecedor(@Valid @RequestBody FornecedorRequestDTO salvarDTO){
        service.salvarFornecedor(salvarDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem","CADASTRO COM SUCESSO"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>>atualizarFornecedor(@PathVariable Long id, @Valid @RequestBody FornecedorRequestDTO atualizarDTO){
        service.atualizarFornecedor(id, atualizarDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO ATUALIZADO COM SUCESSO"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarFornecedor(@PathVariable Long id){
        service.deletarFornecedor(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO DELETADO COM SUCESSO"));
    }

}
