package com.rdr.sglserverjava.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.repositories.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UserDetailServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioAuth loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
            .map(UsuarioAuth::new)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
        
}
