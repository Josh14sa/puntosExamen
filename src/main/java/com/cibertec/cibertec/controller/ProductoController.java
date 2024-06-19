package com.cibertec.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.cibertec.entity.Productos;
import com.cibertec.cibertec.service.ProductosService;

@RestController
@RequestMapping("/url/productos")
public class ProductoController {

    @Autowired
    private ProductosService productosService;

    // Las consultas o búsquedas
    @GetMapping("/listaTodos")
    public List<Productos> getAllProductos() {
        return productosService.listaProductos();
    }

    @GetMapping("/buscarPorNombre")
    public List<Productos> getProductoByNombre(@RequestParam("nombre") String nombre) {
        return productosService.listaProductosPorNombre(nombre + "%");
    }

    // Para el CRUD
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarProducto(@RequestBody Productos productos) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productos.setIdProducto(0);
            Productos objSalida = productosService.insertaActualizaProducto(productos);
            salida.put("mensaje", "Producto registrado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaProducto(@RequestBody Productos productos) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Productos objSalida = productosService.insertaActualizaProducto(productos);
            salida.put("mensaje", "Producto actualizado de ID >>> " + objSalida.getIdProducto());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminaProducto(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            productosService.eliminaProdcuto(id);
            salida.put("mensaje", "Producto eliminado de ID >>> " + id);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Productos productos = productosService.obtienePorId(id).get();
            salida.put("producto", productos);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }
}
