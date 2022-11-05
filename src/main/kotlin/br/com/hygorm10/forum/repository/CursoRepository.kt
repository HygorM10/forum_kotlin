package br.com.hygorm10.forum.repository

import br.com.hygorm10.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}