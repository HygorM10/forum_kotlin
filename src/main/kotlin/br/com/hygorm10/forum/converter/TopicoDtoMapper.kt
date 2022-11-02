package br.com.hygorm10.forum.converter

import br.com.hygorm10.forum.model.Topico
import br.com.hygorm10.forum.model.dto.TopicoDto
import br.com.hygorm10.forum.service.CursoService
import br.com.hygorm10.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoDtoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
):Mapper<TopicoDto, Topico> {
    override fun map(t: TopicoDto): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarCursoPorId(t.idCurso),
            autor = usuarioService.buscaUsuarioPorId(t.idAutor)
        )
    }

}
