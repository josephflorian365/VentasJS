package com.test.test.repository;

import com.test.test.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> getTodos();

    Cliente getTodoById(Long id);

    Cliente insert(Cliente todo);

    void updateTodo(Long id, Cliente todo);

    void deleteTodo(Long todoId);
}
