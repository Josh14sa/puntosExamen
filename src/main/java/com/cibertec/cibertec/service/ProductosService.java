package com.cibertec.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.cibertec.entity.Cliente;
import com.cibertec.cibertec.entity.Productos;

public interface ProductosService {
	
	//Para el CRUD
    public abstract List<Productos> listaProductos();
    public abstract Productos insertaActualizaProducto(Productos obj);
    public abstract void eliminaProdcuto(int id);
    public abstract Optional<Productos> obtienePorId(int id);
    
    //Para consultas
    public abstract List<Productos> listaProductosPorNombre(String nombre);
//    public abstract List<Productos> listaProductosPorNombre(String dni);
//    public abstract List<Productos> listaClientePorDniNombre(String dni, String nombres);

}
