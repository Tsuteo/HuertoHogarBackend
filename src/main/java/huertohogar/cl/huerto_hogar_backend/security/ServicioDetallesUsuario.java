package huertohogar.cl.huerto_hogar_backend.security;

import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;
import huertohogar.cl.huerto_hogar_backend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ServicioDetallesUsuario implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        String rolOriginal = usuario.getRol();
        String rolLimpio = "ROLE_USER";

        if (rolOriginal != null) {
            rolLimpio = rolOriginal.trim().toUpperCase();
            
            if (!rolLimpio.startsWith("ROLE_")) {
                rolLimpio = "ROLE_" + rolLimpio;
            }
        }

        return new User(
                usuario.getEmail(),
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(rolLimpio))
        );
    }
}