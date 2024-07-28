package utn.frc.utn.edu.ar.alquileres_api.Services;


import utn.frc.utn.edu.ar.alquileres_api.Controller.Response.ProductoResponseDto;

import java.util.List;


public interface ProductoService {

    ProductoResponseDto add(String nombre, Float precio, String tipo, int stock);

    List<ProductoResponseDto> alquilerFiltroCosto(Float precio);

    List<ProductoResponseDto> all();

    public ProductoResponseDto modificar(String nombre,Float precio, int stock);

    public List<ProductoResponseDto>allName(String nombre);

    public List<ProductoResponseDto> allTipoProducto(String TipoProducto);
    public void borrar(String nombre);




}
