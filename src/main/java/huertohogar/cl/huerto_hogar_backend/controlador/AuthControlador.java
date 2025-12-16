package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;
import huertohogar.cl.huerto_hogar_backend.security.ServicioJwt;
import huertohogar.cl.huerto_hogar_backend.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Endpoints para registro y login de usuarios")
public class AuthControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ServicioJwt servicioJwt;

    @Operation(summary = "Registrar usuario", description = "Crea una nueva cuenta de cliente en el sistema")
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioServicio.registrar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Iniciar sesión", description = "Recibe email y password y devuelve un JWT")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String password = credenciales.get("password");

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
            );

            final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            final String jwt = servicioJwt.generarToken(userDetails);

            Usuario usuario = usuarioServicio.login(email, password); 

            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("id", usuario.getId());
            response.put("nombre", usuario.getNombre());
            response.put("email", userDetails.getUsername());
            
            String rolLimpio = userDetails.getAuthorities().stream()
                .findFirst()
                .get()
                .getAuthority();
                
            response.put("rol", rolLimpio);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}