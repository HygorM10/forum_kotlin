package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.converter.TopicoDtoMapper
import br.com.hygorm10.forum.converter.TopicoViewMap
import br.com.hygorm10.forum.model.Topico
import br.com.hygorm10.forum.model.dto.AtualizacaoTopicoForm
import br.com.hygorm10.forum.model.dto.TopicoDto
import br.com.hygorm10.forum.model.dto.TopicoView
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMap,
    private val topicoDtoMapper: TopicoDtoMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)

        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(topicoDto: TopicoDto): TopicoView {
        val topico = topicoDtoMapper.map(topicoDto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()

        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            resposta = topico.resposta,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )

        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        topicos = topicos.minus(topico)
    }

}