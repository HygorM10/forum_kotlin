package br.com.hygorm10.forum.repository

import br.com.hygorm10.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}