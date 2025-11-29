package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.*;
import huertohogar.cl.huerto_hogar_backend.repositorio.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrdenServicio {

    @Autowired
    private OrdenRepositorio ordenRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Orden> listarOrdenes() {
        return ordenRepositorio.findAll();
    }

    @Transactional
    public Orden crearOrden(Long usuarioId, List<SolicitudItem> items) {
        
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Orden orden = new Orden();
        orden.setUsuario(usuario);
        
        String codigoUnico = "BOL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        orden.setCodigoBoleta(codigoUnico);
        
        int totalOrden = 0;
        List<DetalleOrden> detalles = new ArrayList<>();

        for (SolicitudItem item : items) {
            Long idProducto = Long.parseLong(item.productoId);

            Producto producto = productoRepositorio.findById(idProducto)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.productoId));

            if (producto.getStock() < item.cantidad) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - item.cantidad);
            productoRepositorio.save(producto);

            DetalleOrden detalle = new DetalleOrden(orden, producto, item.cantidad, producto.getPrecio());
            detalles.add(detalle);
            
            totalOrden += (producto.getPrecio() * item.cantidad);
        }

        orden.setDetalles(detalles);
        orden.setTotal(totalOrden);

        return ordenRepositorio.save(orden);
    }

    public static class SolicitudItem {
        public String productoId;
        public int cantidad;
    }
}