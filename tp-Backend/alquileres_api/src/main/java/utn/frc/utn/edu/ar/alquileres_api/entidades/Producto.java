package utn.frc.utn.edu.ar.alquileres_api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(generator = "PRODUCTO")
    @TableGenerator(name = "PRODUCTO", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="PRODUCTO",
            initialValue=1, allocationSize=1)
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


