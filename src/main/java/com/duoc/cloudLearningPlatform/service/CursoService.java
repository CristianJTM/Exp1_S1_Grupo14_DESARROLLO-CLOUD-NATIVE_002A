package com.duoc.cloudLearningPlatform.service;


import com.duoc.cloudLearningPlatform.dto.CursoDTO;
import com.duoc.cloudLearningPlatform.exception.ResourceNotFoundException;
import com.duoc.cloudLearningPlatform.model.Curso;
import com.duoc.cloudLearningPlatform.model.Usuario;
import com.duoc.cloudLearningPlatform.repository.CursoRepository;
import com.duoc.cloudLearningPlatform.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public Curso findById(Long id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
    }

    public Curso saveCurso(CursoDTO cursoDTO){
        Usuario profesor = usuarioRepository.findById(cursoDTO.getProfesorId())
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));

        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setProfesor(profesor);
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setCosto(cursoDTO.getCosto());

        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id,CursoDTO cursoDTO){
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        Long profesorId = cursoDTO.getProfesorId();
        Usuario profesor = usuarioRepository.findById(profesorId).orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));
        curso.setProfesor(profesor);
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setCosto(cursoDTO.getCosto());
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        cursoRepository.delete(curso);
    }



}
