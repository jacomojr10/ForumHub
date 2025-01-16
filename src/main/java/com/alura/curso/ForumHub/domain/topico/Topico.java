package com.alura.curso.ForumHub.domain.topico;

import com.alura.curso.ForumHub.dto.DadosAtualizacaoTopico;
import com.alura.curso.ForumHub.dto.DadosPostagemTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String autor;
    private String curso;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico;

    public Topico(DadosPostagemTopico dados) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.curso = curso;
        this.ativo = ativo;
        this.statusTopico = statusTopico;
    }

    public void atualizar(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }


    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }


    }
}
