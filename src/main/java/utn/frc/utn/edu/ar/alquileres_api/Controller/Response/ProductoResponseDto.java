package utn.frc.utn.edu.ar.alquileres_api.Controller.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDto {

    private String nombre;
    private String tipo;
    private Float Precio;
    private int stock;
    private Float precioDeLista;


}
