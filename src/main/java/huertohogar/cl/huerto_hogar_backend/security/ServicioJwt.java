package huertohogar.cl.huerto_hogar_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class ServicioJwt {

    private static final String CLAVE_SECRETA = "HuertoHogarClaveSecretaSuperSeguraParaElProyectoDuoc2025";

    public String extraerNombreUsuario(String token) {
        return extraerReclamacion(token, Claims::getSubject);
    }

    public String generarToken(UserDetails detallesUsuario) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("rol", detallesUsuario.getAuthorities().toString()); 
        return generarToken(claims, detallesUsuario);
    }

    public String generarToken(Map<String, Object> reclamacionesExtra, UserDetails detallesUsuario) {
        return Jwts.builder()
                .setClaims(reclamacionesExtra)
                .setSubject(detallesUsuario.getUsername()) 
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(obtenerClaveFirma(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean esTokenValido(String token, UserDetails detallesUsuario) {
        final String nombreUsuario = extraerNombreUsuario(token);
        return (nombreUsuario.equals(detallesUsuario.getUsername())) && !esTokenExpirado(token);
    }


    private boolean esTokenExpirado(String token) {
        return extraerExpiracion(token).before(new Date());
    }

    private Date extraerExpiracion(String token) {
        return extraerReclamacion(token, Claims::getExpiration);
    }

    public <T> T extraerReclamacion(String token, Function<Claims, T> resolvedorDeReclamaciones) {
        final Claims reclamaciones = extraerTodasLasReclamaciones(token);
        return resolvedorDeReclamaciones.apply(reclamaciones);
    }

    private Claims extraerTodasLasReclamaciones(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(obtenerClaveFirma())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key obtenerClaveFirma() {
        byte[] bytesClave = Decoders.BASE64.decode(java.util.Base64.getEncoder().encodeToString(CLAVE_SECRETA.getBytes()));
        return Keys.hmacShaKeyFor(bytesClave);
    }
}