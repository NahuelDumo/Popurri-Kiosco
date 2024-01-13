package utn.frc.utn.edu.ar.alquileres_api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Identity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Precio")
    private Float precio;


    public Producto(String nombre, Float precio, String tipo) {
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
    }
}


