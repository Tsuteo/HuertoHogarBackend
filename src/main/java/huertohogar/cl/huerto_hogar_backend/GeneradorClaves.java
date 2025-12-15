package huertohogar.cl.huerto_hogar_backend;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorClaves {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordRaw = "admin123";
        String passwordEncriptada = encoder.encode(passwordRaw);
        
        System.out.println("------------------------------------------------");
        System.out.println("TU CONTRASEÑA ENCRIPTADA ES:");
        System.out.println(passwordEncriptada);
        System.out.println("------------------------------------------------");
    }
}