package com.duoc.CloudLearningPlatform.repository;

import com.duoc.CloudLearningPlatform.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
