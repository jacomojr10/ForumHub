package com.alura.curso.ForumHub.dto;

import com.alura.curso.ForumHub.domain.topico.StatusTopico;
import com.alura.curso.ForumHub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        LocalDateTime dataCriacao,
        StatusTopico statusTopico) {
    public DadosListagemTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getDataCriacao(),
                topico.getStatusTopico());
    }
}
