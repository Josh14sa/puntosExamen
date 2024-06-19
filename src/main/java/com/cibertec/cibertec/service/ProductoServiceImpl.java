package com.cibertec.cibertec.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.cibertec.entity.Productos;
import com.cibertec.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductosService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Productos> listaProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Productos insertaActualizaProducto(Productos obj) {
        return productoRepository.save(obj);
    }

    @Override
    public void eliminaProdcuto(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<Productos> obtienePorId(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Productos> listaProductosPorNombre(String nombre) {
        return productoRepository.findByNombresLike(nombre);
    }
}
