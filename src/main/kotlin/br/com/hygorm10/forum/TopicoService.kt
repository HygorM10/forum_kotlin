package br.com.hygorm10.forum

import br.com.hygorm10.forum.model.Curso
import br.com.hygorm10.forum.model.Topico
import br.com.hygorm10.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init{
        val topico1 = Topico(
            id = 1,
            titulo = "Titulo 1",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Hygor Martins",
                email = "hygor@email.com"
            )
        )
        topicos = listOf(topico1)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

}