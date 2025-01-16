package com.alura.curso.ForumHub.dto;

import com.alura.curso.ForumHub.domain.topico.StatusTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosPostagemTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        @NotNull
        LocalDateTime dataCriacao,
        StatusTopico statusTopico) {

    public DadosPostagemTopico {
        if (dataCriacao == null){
            dataCriacao = LocalDateTime.now();
        }

        if (statusTopico == null){
            statusTopico = statusTopico.ABERTO;
        }
    }
}
