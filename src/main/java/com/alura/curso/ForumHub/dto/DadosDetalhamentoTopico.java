package com.alura.curso.ForumHub.dto;

import com.alura.curso.ForumHub.domain.topico.StatusTopico;
import com.alura.curso.ForumHub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mensagem,
                                      String curso,
                                      StatusTopico statusTopico,
                                      String autor,
                                      LocalDateTime dataCriacao) {

    public DadosDetalhamentoTopico (Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getCurso(),
                topico.getStatusTopico(),
                topico.getAutor(),
                topico.getDataCriacao());
    }
}
