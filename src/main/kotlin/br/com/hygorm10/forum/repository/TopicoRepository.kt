package br.com.hygorm10.forum.repository

import br.com.hygorm10.forum.model.Topico
import br.com.hygorm10.forum.model.dto.TopicoPorCategoriaDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {

    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>

    @Query("SELECT new br.com.hygorm10.forum.model.dto.TopicoPorCategoriaDto(curso.categoria, COUNT(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>

}