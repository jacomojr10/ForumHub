package com.alura.curso.ForumHub.controller.Controller;

import com.alura.curso.ForumHub.domain.usuario.DadosLogin;
import com.alura.curso.ForumHub.domain.usuario.Usuario;
import com.alura.curso.ForumHub.infra.DadosTokenJWT;
import com.alura.curso.ForumHub.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    public AuthenticationManager manager;

    @Autowired
    public TokenService tokenService;

    @PostMapping
    public ResponseEntity fazerLogin(@RequestBody @Valid DadosLogin dados){

        System.out.println("Recebendo dados de login: " + dados);

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());


        try {
            var authentication = manager.authenticate(authenticationToken);
            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return ResponseEntity.status(401).body("Erro de autenticação");
        }

    }


}
