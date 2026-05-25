package com.duoc.CloudLearningPlatform.controller;


import com.duoc.CloudLearningPlatform.dto.CursoDTO;
import com.duoc.CloudLearningPlatform.model.Curso;
import com.duoc.CloudLearningPlatform.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    //GET •	Consultar todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        return ResponseEntity.ok(cursoService.findAll());
    }

    //GET •	Consultar cuso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.findById(id));
    }

    //POST • Registrar curso
    @PostMapping
    public ResponseEntity<Curso> saveCurso(@RequestBody CursoDTO dto) {
        return ResponseEntity.status(201).body(cursoService.saveCurso(dto));
    }

    //PUT •	Modificar curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody CursoDTO dto) {
        return ResponseEntity.ok(cursoService.updateCurso(id, dto));
    }

    //DELETE • Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id){
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }


}
