package br.com.fiap.controller;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.service.ClienteServiceInterface;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("cadastro")
public class ClienteController {

    private final ClienteServiceInterface clienteService;

    public ClienteController(ClienteServiceInterface clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id)
    {
        System.out.println("getClienteById())");
        Cliente cliente = clienteService.selectCliente(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping("clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        System.out.println("getAllClientes()");
        List<Cliente> lista = clienteService.SelectAllClientes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente,
                                           UriComponentsBuilder builder) {
        System.out.println("addCliente()");
        Cliente savedCliente = clienteService.insertCliente(cliente);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/cliente/{id}").buildAndExpand(savedCliente.getId()).toUri());
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @PutMapping("cliente")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente)
    {
        System.out.println("updateCliente()");
        for (Endereco end : cliente.getEnderecos()) {
            end.setCliente(cliente);
        }
        clienteService.updateCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
        System.out.println("updateCliente()");
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
