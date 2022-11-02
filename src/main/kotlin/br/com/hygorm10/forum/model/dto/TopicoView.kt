package br.com.hygorm10.forum.model.dto

import br.com.hygorm10.forum.model.enum.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
