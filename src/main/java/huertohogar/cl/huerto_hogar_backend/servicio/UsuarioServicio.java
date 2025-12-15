package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;
import huertohogar.cl.huerto_hogar_backend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario usuario) {
        if (usuarioRepositorio.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }
        
        String passEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passEncriptada);

        if (usuario.getRol() == null) {
            usuario.setRol("CLIENTE");
        }
        return usuarioRepositorio.save(usuario);
    }

    public Usuario login(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepositorio.findByEmail(email);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return usuario;
            }
        }
        return null;
    }
}
