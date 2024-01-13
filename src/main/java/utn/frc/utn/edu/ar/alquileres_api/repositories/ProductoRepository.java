package utn.frc.utn.edu.ar.alquileres_api.repositories;


import org.springframework.data.jpa.repository.Query;
import utn.frc.utn.edu.ar.alquileres_api.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.frc.utn.edu.ar.alquileres_api.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT a FROM Producto a WHERE a.precio >= :costo ORDER BY a.precio")
    List<Producto> findAllByCostoGreaterThan(Float costo);

    @Query("SELECT a FROM Producto a WHERE a.nombre = :nombre ")
    Producto findByName(String nombre);

    @Query("SELECT a FROM Producto a WHERE a.nombre like %:nombre% ORDER BY a.nombre")
    List<Producto> findAllByName(String nombre);

    @Query("SELECT a FROM Producto a WHERE a.tipo = :tipoProducto ORDER BY a.nombre")
    List<Producto> findallByTipoProducto(String tipoProducto);
}
