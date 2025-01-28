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

    @Column(name = "precioDeLista")
    private Float precioDeLista;

    @Column(name = "Stock")
    private int stock;


    public Producto(String nombre, Float precio, String tipo, int stock, Float precioDeLista) {
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
        setStock(stock);
        setPrecioDeLista(precioDeLista);

    }
}


