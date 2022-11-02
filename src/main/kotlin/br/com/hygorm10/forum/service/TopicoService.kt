package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.converter.TopicoDtoMapper
import br.com.hygorm10.forum.converter.TopicoViewMap
import br.com.hygorm10.forum.model.Topico
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

    fun cadastrar(topicoDto: TopicoDto) {

        topicos = topicos.plus(topicoDtoMapper.map(topicoDto))

    }

}