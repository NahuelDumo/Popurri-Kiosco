package utn.frc.utn.edu.ar.alquileres_api.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utn.frc.utn.edu.ar.alquileres_api.Controller.Response.ProductoResponseDto;
import utn.frc.utn.edu.ar.alquileres_api.Services.Mappers.ProductoResponseMapper;
import utn.frc.utn.edu.ar.alquileres_api.entidades.Producto;
import utn.frc.utn.edu.ar.alquileres_api.exceptions.ResourceNotFoundException;
import utn.frc.utn.edu.ar.alquileres_api.repositories.ProductoRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;
    private ProductoResponseMapper productoResponseMapper;



    @Override
    public ProductoResponseDto add(String nombre, Float precio, String tipo) {

        Producto producto = crearProducto(nombre, precio, tipo);
        Producto creado = productoRepository.save(producto);
        return productoResponseMapper.apply(creado);

    }

    private Producto crearProducto(String nombre,  Float precio , String tipo) {

        Producto producto = new Producto(nombre,  precio, tipo);

        return producto;

    }


    public List<ProductoResponseDto> alquilerFiltroCosto(Float costo){
        List<Producto> productoList = productoRepository.findAllByCostoGreaterThan(costo);
        return productoList.stream().map(producto -> productoResponseMapper.apply(producto)).toList();
    }

    @Override
    public List<ProductoResponseDto> all() {
        List<Producto> productosOrdenados = productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
        return productosOrdenados.stream().map(a -> productoResponseMapper.apply(a)).toList();    
    }

    @Override
    public ProductoResponseDto modificar(String nombre , Float precio) {
        Producto producto = productoRepository.findByName(nombre);
        producto.setPrecio(precio);
        productoRepository.save(producto);
        return productoResponseMapper.apply(producto);
    }

    public List<ProductoResponseDto> allName(String nombre ) {
        List<Producto> producto = productoRepository.findAllByName(nombre);
        return producto.stream().map(productoResponseMapper).toList();
    }

    public List<ProductoResponseDto> allTipoProducto(String TipoProducto) {
        List<Producto> producto = productoRepository.findallByTipoProducto(TipoProducto);
        return producto.stream().map(productoResponseMapper).toList();
    }

    public void borrar(String nombre){
        Producto producto = productoRepository.findByName(nombre);
        productoRepository.delete(producto);
    }
}

