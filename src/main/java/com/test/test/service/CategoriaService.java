package com.test.test.service;

import com.test.test.model.Categoria;
import com.test.test.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crear(Categoria categoria) {
        categoria.setEstado("ACTIVO");
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizar(Categoria cliente) {
        return categoriaRepository.save(cliente);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria cambiarEstado(Long id) {
        Categoria categoriaFromDb = categoriaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        categoriaFromDb.setEstado("INACTIVO");
        return categoriaRepository.save(categoriaFromDb);
    }

    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User by id"+id+"was not found "));
    }

    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> obtenerClientes(int numeroPagina, int tamanioPagina, String campoOrden, String sentidoOrden) {

        Pageable pageable = PageRequest.of(numeroPagina - 1, tamanioPagina,
                sentidoOrden.equals("asc") ? Sort.by(campoOrden).ascending() : Sort.by(campoOrden).descending());

        return categoriaRepository.findAll(pageable);
    }
}
