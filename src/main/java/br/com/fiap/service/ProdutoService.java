package br.com.fiap.service;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ProdutoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService implements ProdutoServiceInterface {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Cacheable(value= "allProdutosCache", unless= "#result.size() == 0")
    public List<Produto> SelectAllProdutos() {
        System.out.println("SelectAllProdutos()");
        List<Produto> lista = new ArrayList<>();
        produtoRepository.findAll().forEach(e -> lista.add(e));
        return lista;
    }

    @Override
    @Cacheable(value= "produtoCache", key= "#id", unless="#result == null")
    public Produto selectProduto(Long id) {
        System.out.println("selectProduto()");
        Produto prd = null;
        if (produtoRepository.existsById(id)) {
            prd = produtoRepository.findById(id).get();
        }
        return prd;
    }

    @Override
    @Caching(
            put= { @CachePut(value= "produtoCache", key= "#produto.id", unless="#produto.id==0") },
            evict= { @CacheEvict(value= "allProdutosCache", allEntries= true) }
    )
    public Produto insertProduto(Produto produto) {
        System.out.println("insertProduto()");
        Produto produtoInserted = produtoRepository.save(produto);
        return(produtoInserted);
    }

    @Override
    @Caching(
            put= { @CachePut(value= "produtoCache", key= "#produto.id") },
            evict= { @CacheEvict(value= "allProdutosCache", allEntries= true) }
    )
    public Produto updateProduto(Produto produto) {
        System.out.println("updateProduto()");
        Produto produtoInserted = produtoRepository.save(produto);
        return(produtoInserted);
    }

    @Override
    @Caching(
            evict= {
                    @CacheEvict(value= "produtoCache", key= "#id"),
                    @CacheEvict(value= "allProdutosCache", allEntries= true)
            }
    )
    public void deleteProduto(Long id) {
        System.out.println("deleteProduto()");
        produtoRepository.delete(produtoRepository.findById(id).get());
    }
}
