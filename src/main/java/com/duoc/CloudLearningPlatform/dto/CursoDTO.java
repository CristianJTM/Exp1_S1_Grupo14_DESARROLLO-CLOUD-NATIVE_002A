package com.duoc.CloudLearningPlatform.dto;

public class CursoDTO {
    private String nombre;
    private String descripcion;
    private Long profesorId;

    public CursoDTO(){}

    public CursoDTO(String nombre, String descripcion, Long profesorId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesorId = profesorId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }
}
