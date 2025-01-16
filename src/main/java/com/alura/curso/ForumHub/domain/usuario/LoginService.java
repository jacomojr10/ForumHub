package com.alura.curso.ForumHub.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

    @Service
    public class LoginService implements UserDetailsService {

        @Autowired
        private UsuarioRepository repository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return repository.findByEmail(email);
        }
    }

