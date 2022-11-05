package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.model.Usuario
import br.com.hygorm10.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscaUsuarioPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }

}
