package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;
import huertohogar.cl.huerto_hogar_backend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioCRUD {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> obtenerTodos() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {

        if (usuario.getId() != null) {
            Usuario usuarioAntiguo = usuarioRepositorio.findById(usuario.getId()).orElse(null);
            
            if (usuarioAntiguo != null && (usuario.getPassword() == null || usuario.getPassword().isEmpty())) {
                usuario.setPassword(usuarioAntiguo.getPassword());
            } 
            else if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
        } 
        else {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
