package utn.frc.utn.edu.ar.alquileres_api.Controller.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDto {

    String nombre;
    String tipo;
    Float precio;
    int stock;

}