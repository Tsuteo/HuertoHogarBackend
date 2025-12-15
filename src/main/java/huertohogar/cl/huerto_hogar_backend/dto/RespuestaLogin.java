package huertohogar.cl.huerto_hogar_backend.dto;

public class RespuestaLogin {
    private String token;
    private String email;
    private String rol;
    private String nombre;

    public RespuestaLogin() {}

    public RespuestaLogin(String token, String email, String rol, String nombre) {
        this.token = token;
        this.email = email;
        this.rol = rol;
        this.nombre = nombre;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}