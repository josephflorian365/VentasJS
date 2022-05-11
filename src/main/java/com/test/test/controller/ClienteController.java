package com.test.test.controller;

import com.test.test.model.Cliente;
import com.test.test.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        List<Cliente> employees = clienteService.obtenerTodos();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/clientes/encontrar/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("id") Long id){
        Cliente cliente = clienteService.obtenerPorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevoCliente = clienteService.crear(cliente);
        return new ResponseEntity<>(nuevoCliente,HttpStatus.CREATED);
    }

    @PutMapping("/clientes/actualizar")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
        Cliente actualizadoCliente = clienteService.actualizar(cliente);
        return new ResponseEntity<>(actualizadoCliente,HttpStatus.OK);
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public ResponseEntity<Cliente> eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/clientes/actualizarEstado/{id}")
    public ResponseEntity<Cliente> actualizarEstadoCliente(@PathVariable("id") Long id){
        Cliente actualizadoCliente = clienteService.cambiarEstado(id);
        return new ResponseEntity<>(actualizadoCliente,HttpStatus.OK);
    }

}
