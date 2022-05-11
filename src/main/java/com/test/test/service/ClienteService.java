package com.test.test.service;

import com.test.test.model.Cliente;
import com.test.test.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crear(Cliente cliente) {
        cliente.setEstado("ACTIVO");
        cliente.setFechaRegistro(LocalDate.now());
        cliente.setFechaModificacion(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente cambiarEstado(Long id) {
        Cliente clienteFromDb = clienteRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        clienteFromDb.setEstado("INACTIVO");
        return clienteRepository.save(clienteFromDb);
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User by id"+id+"was not found "));
    }

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

}
