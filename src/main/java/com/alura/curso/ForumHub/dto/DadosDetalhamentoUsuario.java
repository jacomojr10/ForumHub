package com.alura.curso.ForumHub.dto;

import com.alura.curso.ForumHub.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(Long id, String email, String senha) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getSenha());
    }
}
