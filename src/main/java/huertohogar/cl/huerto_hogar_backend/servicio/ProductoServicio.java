package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Producto;
import huertohogar.cl.huerto_hogar_backend.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> obtenerTodos() {
        return productoRepositorio.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepositorio.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        return productoRepositorio.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}