package com.alura.curso.ForumHub.controller.Controller;


import com.alura.curso.ForumHub.domain.usuario.Usuario;
import com.alura.curso.ForumHub.domain.usuario.UsuarioRepository;

import com.alura.curso.ForumHub.dto.DadosCadastroUsuario;
import com.alura.curso.ForumHub.dto.DadosDetalhamentoUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){

        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);

        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
}
