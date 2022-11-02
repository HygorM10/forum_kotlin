package br.com.hygorm10.forum.converter

import br.com.hygorm10.forum.model.Topico
import br.com.hygorm10.forum.model.dto.TopicoView
import org.springframework.stereotype.Component

@Component
class TopicoViewMap: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }

}