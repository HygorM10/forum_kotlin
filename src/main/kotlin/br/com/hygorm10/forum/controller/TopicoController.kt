package br.com.hygorm10.forum.controller

import br.com.hygorm10.forum.model.dto.AtualizacaoTopicoForm
import br.com.hygorm10.forum.model.dto.TopicoDto
import br.com.hygorm10.forum.model.dto.TopicoPorCategoriaDto
import br.com.hygorm10.forum.model.dto.TopicoView
import br.com.hygorm10.forum.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    @Cacheable("topicos")
    fun listar(
        @RequestParam(required = false) nomeCurso: String?,
        @PageableDefault(size = 10, page = 0) paginacao: Pageable
    ): Page<TopicoView> {
        return service.listar(nomeCurso, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoriaDto>{
        return service.relatorio()
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun cadastrar(
        @RequestBody @Valid topicoDto: TopicoDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(topicoDto)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun atualizar(
        @RequestBody @Valid form: AtualizacaoTopicoForm
    ): ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["topicos"], allEntries = true)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}