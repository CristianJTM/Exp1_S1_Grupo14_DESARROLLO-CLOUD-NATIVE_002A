package com.duoc.cloudLearningPlatform.repository;

import com.duoc.cloudLearningPlatform.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
