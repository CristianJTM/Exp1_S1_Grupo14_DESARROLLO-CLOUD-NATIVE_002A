package com.duoc.CloudLearningPlatform.service;


import com.duoc.CloudLearningPlatform.dto.EvaluacionDTO;
import com.duoc.CloudLearningPlatform.exception.ResourceNotFoundException;
import com.duoc.CloudLearningPlatform.model.Curso;
import com.duoc.CloudLearningPlatform.model.Evaluacion;
import com.duoc.CloudLearningPlatform.repository.CursoRepository;
import com.duoc.CloudLearningPlatform.repository.EvaluacionRepository;
import com.duoc.CloudLearningPlatform.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> findAll(){
        return evaluacionRepository.findAll();
    }

    public Evaluacion findById(Long id){
        return evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluacion no encontrada"));
    }

    public List<Evaluacion> findByCurso(Long cursoId){
        return evaluacionRepository.findByCursoId(cursoId);
    }

    public Evaluacion saveEvaluacion(EvaluacionDTO evaluacionDTO){
        Curso curso = cursoRepository.findById(evaluacionDTO.getCursoId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setCurso(curso);
        evaluacion.setNombre(evaluacionDTO.getNombre());
        evaluacion.setPuntajeMaximo(evaluacionDTO.getPuntajeMaximo());
        evaluacion.setFechaAplicacion(evaluacionDTO.getFechaAplicacion());

        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion updateEvaluacion(Long id,EvaluacionDTO evaluacionDTO){
        Evaluacion evaluacion = evaluacionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluacion no encontrada"));

        evaluacion.setNombre(evaluacionDTO.getNombre());
        evaluacion.setPuntajeMaximo(evaluacionDTO.getPuntajeMaximo());
        evaluacion.setFechaAplicacion(evaluacionDTO.getFechaAplicacion());

        Long cursoId = evaluacionDTO.getCursoId();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        evaluacion.setCurso(curso);

        return evaluacionRepository.save(evaluacion);
    }

    public void deleteEvaluacion(Long id){
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluacion no encontrada"));
        evaluacionRepository.delete(evaluacion);
    }
}
