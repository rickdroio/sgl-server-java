package com.rdr.sglserverjava.security;

import java.time.Instant;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class JwtService {
    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        long expire = 86400L; // 1 dia        

        UsuarioAuth usuarioAuth = (UsuarioAuth) authentication.getPrincipal();

        System.out.println(usuarioAuth.getTenantId());

/*         String scopes = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" ")); */

        var claims = JwtClaimsSet.builder()
            .issuer("sgl-server-java")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expire))
            .subject(authentication.getName())
            .claim("tenantid", 666)
            .build();

        String jsonToken = new Gson().toJson(encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        
        return jsonToken;
    }   
    
}
