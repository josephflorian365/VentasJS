package com.test.test.service;

import com.test.test.model.Categoria;
import com.test.test.model.Producto;
import com.test.test.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crear(Producto producto) {
        producto.setEstado("ACTIVO");
        producto.setFecha(LocalDateTime.now());
        return productoRepository.save(producto);
    }

    public Producto actualizar(Producto cliente) {
        return productoRepository.save(cliente);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto cambiarEstado(Long id) {
        Producto clienteFromDb = productoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        clienteFromDb.setEstado("INACTIVO");
        return productoRepository.save(clienteFromDb);
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User by id"+id+"was not found "));
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Page<Producto> obtenerClientes(int numeroPagina, int tamanioPagina, String campoOrden, String sentidoOrden) {

        Pageable pageable = PageRequest.of(numeroPagina - 1, tamanioPagina,
                sentidoOrden.equals("asc") ? Sort.by(campoOrden).ascending() : Sort.by(campoOrden).descending());

        return productoRepository.findAll(pageable);
    }
}
