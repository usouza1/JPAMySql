package br.com.fiap.service;

import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements ClienteServiceInterface {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> SelectAllClientes() {
        System.out.println("SelectAllClientes()");
        List<Cliente> lista = new ArrayList<>();
        clienteRepository.findAll().forEach(e -> lista.add(e));
        return lista;
    }

    @Override
    @Cacheable(value="clienteCache", key= "#id", unless="#result == null")
    public Cliente selectCliente(Long id) {
        System.out.println("selectCliente()");
        Cliente cli = null;
        if (clienteRepository.existsById(id)) {
            cli = clienteRepository.findById(id).get();
            final int qtdEnd = cli.getEnderecos().size();
            final int qtdCar = cli.getCarrinhos().size();
            final int qtdPed = cli.getPedidos().size();
        }
        return cli;
    }

    @Override
    @Caching(
            put= { @CachePut(value="clienteCache", key="#cliente.id", unless="#cliente.id==0") }
    )
    public Cliente insertCliente(Cliente cliente) {
        System.out.println("insertCliente()");
        Cliente clienteInserted = clienteRepository.save(cliente);
        return(clienteInserted);
    }

    @Override
    @Caching(
            put= { @CachePut(value= "clienteCache", key= "#cliente.id") }
    )
    public Cliente updateCliente(Cliente cliente) {
        System.out.println("updateCliente()");
        Cliente clienteInserted = clienteRepository.save(cliente);
        return(clienteInserted);
    }

    @Override
    @Caching(
            evict= {
                    @CacheEvict(value= "clienteCache", key= "#id")
            }
    )
    public void deleteCliente(Long id) {
        System.out.println("deleteCliente()");
        clienteRepository.delete(clienteRepository.findById(id).get());
    }

}
