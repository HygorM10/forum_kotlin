package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.model.Curso
import br.com.hygorm10.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarCursoPorId(id: Long): Curso {
        return repository.getReferenceById(id)
    }

}
