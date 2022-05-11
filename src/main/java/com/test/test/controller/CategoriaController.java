package com.test.test.controller;

import com.test.test.model.Categoria;
import com.test.test.model.Cliente;
import com.test.test.service.CategoriaService;
import com.test.test.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    //obtener todas las categorias
    @GetMapping("")
    public ResponseEntity<List<Categoria>> obtenerCategorias(){
        List<Categoria> categorias = categoriaService.obtenerTodos();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    //obtener categorias por id
    @GetMapping("/encontrar/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable("id") Long id){
        Categoria categoria = categoriaService.obtenerPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    //creación de una nueva categoria
    @PostMapping("/crear")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria nuevaCategoria = categoriaService.crear(categoria);
        return new ResponseEntity<>(nuevaCategoria,HttpStatus.CREATED);
    }

    //actualización de categoria
    @PutMapping("/actualizar")
    public ResponseEntity<Categoria> actualizarCategoria(@RequestBody Categoria categoria){
        Categoria actualizadoCategoria = categoriaService.actualizar(categoria);
        return new ResponseEntity<>(actualizadoCategoria,HttpStatus.OK);
    }

    //eliminación de categoria
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable("id") Long id){
        categoriaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //eliminación lógica de categoria
    @PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Categoria> actualizarEstadoCategoria(@PathVariable("id") Long id){
        Categoria actualizadoCategoria = categoriaService.cambiarEstado(id);
        return new ResponseEntity<>(actualizadoCategoria,HttpStatus.OK);
    }

    //lista paginada de categoria
    @GetMapping("/paginado")
    public ResponseEntity<Page<Categoria>> paginadoCategorias(Pageable pageable){
        Page<Categoria> categorias = categoriaService.obtenerClientes(1, 5, "nombre", "desc");
        return new ResponseEntity<>(categorias,HttpStatus.OK);
    }
}
