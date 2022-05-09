package br.com.fiap.controller;

import br.com.fiap.entity.Produto;
import br.com.fiap.service.ProdutoServiceInterface;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class ProdutoController {

    private final ProdutoServiceInterface produtoService;

    public ProdutoController(ProdutoServiceInterface produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id)
    {
        System.out.println("getProdutoById())");
        Produto produto = produtoService.selectProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping("produtos")
    public ResponseEntity<List<Produto>> getAllProdutos() {
        System.out.println("getAllProdutos()");
        List<Produto> lista = produtoService.SelectAllProdutos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("produto")
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto,
                                           UriComponentsBuilder builder) {
        System.out.println("addProduto()");
        Produto savedProduto = produtoService.insertProduto(produto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/produto/{id}").buildAndExpand(savedProduto.getId()).toUri());
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }

    @PutMapping("produto")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto)
    {
        System.out.println("updateProduto()");
        produtoService.updateProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Long id) {
        System.out.println("deleteProduto()");
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
