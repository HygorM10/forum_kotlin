package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nome= "Kotlin",
            categoria = "Kotlin"
        )
        cursos = listOf(curso)
    }

    fun buscarCursoPorId(id: Long): Curso {
        return cursos.stream().filter {
            c -> c.id == id
        }.findFirst().get()
    }

}
