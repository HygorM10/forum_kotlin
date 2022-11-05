package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.converter.TopicoDtoMapper
import br.com.hygorm10.forum.converter.TopicoViewMap
import br.com.hygorm10.forum.exception.NotFoundException
import br.com.hygorm10.forum.model.dto.AtualizacaoTopicoForm
import br.com.hygorm10.forum.model.dto.TopicoDto
import br.com.hygorm10.forum.model.dto.TopicoPorCategoriaDto
import br.com.hygorm10.forum.model.dto.TopicoView
import br.com.hygorm10.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMap,
    private val topicoDtoMapper: TopicoDtoMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return repository.relatorio()
    }

    fun cadastrar(topicoDto: TopicoDto): TopicoView {
        val topico = topicoDtoMapper.map(topicoDto)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}