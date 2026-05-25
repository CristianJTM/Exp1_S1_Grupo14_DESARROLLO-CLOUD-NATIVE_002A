package com.duoc.CloudLearningPlatform.controller;

import com.duoc.CloudLearningPlatform.dto.UsuarioDTO;
import com.duoc.CloudLearningPlatform.model.Usuario;
import com.duoc.CloudLearningPlatform.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController  {

    @Autowired
    private UsuarioService usuarioService;

    //GET •	Consultar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //GET •	Consultar usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    //POST • Registrar usuario
    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.status(201).body(usuarioService.saveUsuario(dto));
    }

    //PUT •	Modificar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, dto));
    }
    //DELETE • Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
