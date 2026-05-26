package com.example.avaliacao20260520.controller;

import com.example.avaliacao20260520.dto.FuncionarioRequestDTO;
import com.example.avaliacao20260520.dto.FuncionarioResponseDTO;
import com.example.avaliacao20260520.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listarFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarFunc());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarFuncionario(@RequestBody @Valid FuncionarioRequestDTO funcCadastroDTO){
        service.salvarFunc(funcCadastroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "CADASTRADO COM SUCESSO ✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> AtualizarCadastroFunc(@PathVariable Long id, @RequestBody @Valid  FuncionarioRequestDTO funcAtualizarDTO){
        service.atualizarFunc(id, funcAtualizarDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO ATUALIZADO COM SUCESSO✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarFuncionario(@PathVariable Long id){
        service.deletarFuncionario(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem","CADASTRO DELETADO COM SUCESSO ✅" ));
    }





}
