package br.com.fiap;

import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Produto;
import br.com.fiap.entity.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class PersistenceApplication {
    static String URIPadrao = "http://localhost:8080/spring-app/";

    public static void main(String[] args) {
        Random gerador = new Random();

        SpringApplication.run(PersistenceApplication.class, args);

        // Apagando os registros de cache
        clearCache();

    }

    public static Produto addProdutoDemo(Produto objProduto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "estoque/produto";
        HttpEntity<Produto> requestEntity = new HttpEntity<>(objProduto, headers);
        ResponseEntity<Produto> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity,
                Produto.class, objProduto);
        Produto produto = responseEntity.getBody();
        return(produto);
    }

    public static Cliente addClienteDemo(Cliente objCliente) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "cadastro/cliente";
        HttpEntity<Cliente> requestEntity = new HttpEntity<>(objCliente, headers);
        ResponseEntity<Cliente> responseEntity = restTemplate.exchange(url,
                HttpMethod.POST, requestEntity,
                Cliente.class, objCliente);
        Cliente cliente = responseEntity.getBody();
        return(cliente);
    }

    public static Cliente updateClienteDemo(Cliente objCliente) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "cadastro/cliente";
        HttpEntity<Cliente> requestEntity = new HttpEntity<Cliente>(objCliente, headers);
        ResponseEntity<Cliente> responseEntity = restTemplate.exchange(url,
                HttpMethod.PUT, requestEntity,
                Cliente.class, objCliente);
        Cliente cliente = responseEntity.getBody();
        return(cliente);
    }

    public static Produto getProdutoByIdDemo(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "estoque/produto/"+Long.toString(id);
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Produto> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Produto.class, id);
        Produto produto = responseEntity.getBody();
        return(produto);
    }

    public static Cliente getClienteByIdDemo(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "cadastro/cliente/"+Long.toString(id);
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Cliente> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Cliente.class, id);
        Cliente cliente = responseEntity.getBody();
        return(cliente);
    }

    public static Produto[] getAllProdutosDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "estoque/produtos";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Produto[]> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Produto[].class);
        Produto[] produtos = responseEntity.getBody();
        return(produtos);
    }

    public static Cliente[] getAllClientesDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "cadastro/clientes";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Cliente[]> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, requestEntity,
                Cliente[].class);
        Cliente[] clientes = responseEntity.getBody();
        return(clientes);
    }

    public static void clearCache() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = URIPadrao + "server/clearCache";
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
    }

}
