package com.alura.curso.ForumHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(

        @NotBlank
        String email,
        @NotBlank
        String senha) {

}
