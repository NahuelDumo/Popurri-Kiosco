package utn.frc.utn.edu.ar.alquileres_api.Services.Mappers;


import org.springframework.stereotype.Service;
import utn.frc.utn.edu.ar.alquileres_api.Controller.Response.ProductoResponseDto;
import utn.frc.utn.edu.ar.alquileres_api.entidades.Producto;

import java.util.function.Function;

@Service
public class ProductoResponseMapper implements Function<Producto, ProductoResponseDto> {
    @Override
    public ProductoResponseDto apply(Producto producto) {
        return new ProductoResponseDto(
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecio());
    }
}
