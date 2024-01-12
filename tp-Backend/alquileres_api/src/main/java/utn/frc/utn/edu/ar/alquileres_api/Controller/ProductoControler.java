package utn.frc.utn.edu.ar.alquileres_api.Controller;

import org.springframework.web.bind.annotation.*;
import utn.frc.utn.edu.ar.alquileres_api.Controller.Request.ProductoRequestDto;
import utn.frc.utn.edu.ar.alquileres_api.Controller.Response.ProductoResponseDto;
import utn.frc.utn.edu.ar.alquileres_api.Services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
@CrossOrigin("*")
public class ProductoControler {
    private ProductoService productoService;

    @PostMapping()
    public ResponseEntity<ProductoResponseDto> add(@RequestBody ProductoRequestDto dto) {
        ProductoResponseDto response = productoService.add(dto.getNombre(), dto.getPrecio(), dto.getTipo());
        return new ResponseEntity<ProductoResponseDto>(response, HttpStatusCode.valueOf(201));

    }

    @GetMapping()
    public ResponseEntity<List<ProductoResponseDto>> ProductoFiltradoCosto(@RequestParam Float precio){
        List<ProductoResponseDto> response = productoService.alquilerFiltroCosto(precio);
        if(response.isEmpty())return new ResponseEntity<List<ProductoResponseDto>>(response, HttpStatusCode.valueOf(204));
        return new ResponseEntity<List<ProductoResponseDto>>(response, HttpStatusCode.valueOf(200));

    }

    @GetMapping("/")
    public ResponseEntity<List<ProductoResponseDto>> ProductosTodos(){
        List<ProductoResponseDto> response = productoService.all();
        if(response.isEmpty())return new ResponseEntity<List<ProductoResponseDto>>(response, HttpStatusCode.valueOf(204));
        return new ResponseEntity<List<ProductoResponseDto>>(response, HttpStatusCode.valueOf(200));

    }

    @PutMapping()
    public ResponseEntity<ProductoResponseDto> Modificar(@RequestBody ProductoRequestDto dto) {
        ProductoResponseDto response = productoService.modificar(dto.getNombre(), dto.getPrecio());
        return new ResponseEntity<ProductoResponseDto>(response, HttpStatusCode.valueOf(201));

    }

    @GetMapping("-")
    public ResponseEntity<List<ProductoResponseDto>> ProductoNombreTodos(@RequestParam String nombre){
        List<ProductoResponseDto> response = productoService.allName(nombre);
        if(response.isEmpty())return new ResponseEntity<>(response, HttpStatusCode.valueOf(204));
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));

    }

    @GetMapping("/Tipo")
    public ResponseEntity<List<ProductoResponseDto>>ProductosTipoTodos(@RequestParam String tipo){
        List<ProductoResponseDto> response = productoService.allTipoProducto(tipo);
        if(response.isEmpty())return new ResponseEntity<>(response, HttpStatusCode.valueOf(204));
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));

    }

    @DeleteMapping("/Eliminar")
    public void Eliminar(@RequestParam String nom){
        productoService.borrar(nom);
    }


}


