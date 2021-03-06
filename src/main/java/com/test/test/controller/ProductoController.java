package com.test.test.controller;

import com.test.test.model.Categoria;
import com.test.test.model.Producto;
import com.test.test.service.CategoriaService;
import com.test.test.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    //obtener todas las productos
    @GetMapping("")
    public ResponseEntity<List<Producto>> obtenerProductos(){
        List<Producto> productos = productoService.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //obtener producto por id
    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable("id") Long id){
        Producto producto = productoService.obtenerPorId(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    //creación de una nueva producto
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Object> crearProducto(@RequestBody @Valid Producto producto
            , BindingResult result){
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.OK);
        } else {
            List<Producto> productos = productoService.obtenerTodos();
            if (productos.stream().anyMatch(it -> producto.getNombre().equals(it.getNombre()))) {
                return new ResponseEntity<>(
                        Collections.singletonList("Nombre ya existe!"),
                        HttpStatus.CONFLICT);
            } else {
                Producto nuevoProducto = productoService.crear(producto);
                return new ResponseEntity<>(nuevoProducto,HttpStatus.CREATED);
            }
        }

    }

    //actualización de producto
    @PutMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        Producto actualizadoProducto = productoService.actualizar(producto);
        return new ResponseEntity<>(actualizadoProducto,HttpStatus.OK);
    }

    //eliminación de producto
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id") Long id){
        productoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //eliminación lógica de producto
    @PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Producto> actualizarEstadoProducto(@PathVariable("id") Long id){
        Producto actualizadoProducto = productoService.cambiarEstado(id);
        return new ResponseEntity<>(actualizadoProducto,HttpStatus.OK);
    }

    //lista paginada de productos
    @GetMapping("/paginado")
    public ResponseEntity<Page<Producto>> paginadoProductos(Pageable pageable){
        Page<Producto> productos = productoService.obtenerClientes(1, 5, "nombre", "desc");
        return new ResponseEntity<>(productos,HttpStatus.OK);
    }
}
