package br.com.hygorm10.forum.model.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicoDto(
    @field:NotEmpty @field:Size(min = 5, max = 18) val titulo: String,
    @field:NotEmpty val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)
