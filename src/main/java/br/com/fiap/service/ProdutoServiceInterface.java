package br.com.fiap.service;

import br.com.fiap.entity.Produto;

import java.util.List;

public interface ProdutoServiceInterface {
    List<Produto> SelectAllProdutos();
    Produto selectProduto(Long id);
    Produto insertProduto(Produto produto);
    Produto updateProduto(Produto produto);
    void deleteProduto(Long id);
}
