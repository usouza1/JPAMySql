package br.com.fiap.service;

import br.com.fiap.entity.Cliente;

import java.util.List;

public interface ClienteServiceInterface {
    List<Cliente> SelectAllClientes();
    Cliente selectCliente(Long id);
    Cliente insertCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
    void deleteCliente(Long id);
}
