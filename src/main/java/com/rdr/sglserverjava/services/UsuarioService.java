package com.rdr.sglserverjava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.dtos.UsuarioDto;
import com.rdr.sglserverjava.models.UsuarioModel;
import com.rdr.sglserverjava.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioModel newUser(UsuarioDto usuarioDto) {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);

        usuarioModel.setPassword(passwordEncoder.encode(usuarioDto.password()));

        return usuarioRepository.save(usuarioModel);
    }    
}
