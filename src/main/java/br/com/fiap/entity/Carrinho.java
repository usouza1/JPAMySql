package br.com.fiap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Car")
public class Carrinho extends AbstractEntity implements Serializable {

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="CLI_ID", nullable=false)
    private Cliente cliente;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="PRD_ID", nullable=false)
    private Produto produto;

    @Column(name="NrQtd", nullable=false, precision=9)
    private Integer quantidade;

    public Carrinho() {
        super();
        this.quantidade = 0;
        this.cliente = new Cliente();
        this.produto = new Produto();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }



}
