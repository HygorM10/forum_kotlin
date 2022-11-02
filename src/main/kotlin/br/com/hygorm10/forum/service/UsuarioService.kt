package br.com.hygorm10.forum.service

import br.com.hygorm10.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Hygor Martins",
            email = "Hygor@email.com"
        )

        usuarios = listOf(usuario)
    }

    fun buscaUsuarioPorId(id: Long): Usuario {
        return usuarios.stream().filter {
            u -> u.id == id
        }.findFirst().get()
    }

}
