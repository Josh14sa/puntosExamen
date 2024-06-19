package com.cibertec.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cibertec.cibertec.entity.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer> {
	
	//Aplicando Query methods
    public abstract List<Productos> findByNombre(String nombre);
    public abstract List<Productos> findByNombresLike(String nombre);
    
//    //Aplicadon JPQL (Java Persistence Query Language)
//    @Query("SELECT x FROM Productos x WHERE x.nombres = ?1 AND x.nombres = ?2")
//    public abstract List<Productos> findByDniAndNombres(String dni, String nombres);

}
