package com.duoc.CloudLearningPlatform.controller;

import com.duoc.CloudLearningPlatform.dto.EvaluacionDTO;
import com.duoc.CloudLearningPlatform.model.Evaluacion;
import com.duoc.CloudLearningPlatform.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;


    //GET •	Consultar todas las evaluaciones
    @GetMapping
    public ResponseEntity<List<Evaluacion>> findAll(){
        return ResponseEntity.ok(evaluacionService.findAll());
    }

    //GET •	Consultar evaluacion por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> findById(@PathVariable Long id){
        return ResponseEntity.ok(evaluacionService.findById(id));
    }

    //GET •	Consultar evaluacion por curso
    @GetMapping("/curso/{id}")
    public ResponseEntity<List<Evaluacion>> findByCurso(@PathVariable Long id){
        return ResponseEntity.ok(evaluacionService.findByCurso(id));
    }

    //POST • Registrar evaluacion
    @PostMapping
    public ResponseEntity<Evaluacion> saveEvaluacion(@RequestBody EvaluacionDTO dto) {
        return ResponseEntity.status(201).body(evaluacionService.saveEvaluacion(dto));
    }

    //PUT •	Modificar evaluacion
    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> updateEvaluacion(@PathVariable Long id, @RequestBody EvaluacionDTO dto) {
        return ResponseEntity.ok(evaluacionService.updateEvaluacion(id, dto));
    }

    //DELETE • Eliminar evaluacion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluacion(@PathVariable Long id){
        evaluacionService.deleteEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}
