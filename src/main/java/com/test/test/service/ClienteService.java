package com.test.test.service;

import com.test.test.exception.UserNotFoundException;
import com.test.test.model.Cliente;
import com.test.test.model.Estado;
import com.test.test.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente cambiarEstado(Cliente cliente) {
        cliente.setEstado(Estado.INACTIVO);
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found "));
    }

    public void obtenerTodos(Cliente cliente) {

    }

    public void listaPaginada(Cliente cliente) {

    }

}
