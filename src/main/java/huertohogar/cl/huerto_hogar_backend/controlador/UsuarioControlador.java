package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;
import huertohogar.cl.huerto_hogar_backend.servicio.UsuarioServicioCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
@Tag(name = "Gestión de Usuarios", description = "Administración de perfiles y roles de usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicioCRUD usuarioServicio;

    @Operation(summary = "Listar usuarios", description = "Obtiene la lista completa de usuarios registrados")
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioServicio.obtenerTodos();
    }

    @Operation(summary = "Obtener usuario por ID", description = "Busca los datos de perfil de un usuario específico")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioServicio.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear usuario (Manual)", description = "Crea un usuario directamente en la base de datos")
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @Operation(summary = "Actualizar usuario y Rol", description = "Modifica datos del usuario, incluyendo el cambio de ROL")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario datos) {
        Optional<Usuario> usuarioOptional = usuarioServicio.obtenerPorId(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(datos.getNombre());
            usuarioExistente.setEmail(datos.getEmail());
            usuarioExistente.setPassword(datos.getPassword());
            usuarioExistente.setRol(datos.getRol());

            return ResponseEntity.ok(usuarioServicio.guardarUsuario(usuarioExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar usuario", description = "Elimina permanentemente un usuario del sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioServicio.obtenerPorId(id);
        if (usuario.isPresent()) {
            usuarioServicio.eliminarUsuario(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
