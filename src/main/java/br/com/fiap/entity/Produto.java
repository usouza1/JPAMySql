package br.com.fiap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="Prd")
public class Produto extends AbstractEntity implements Serializable {

    @Column(name="NmPrd", unique=true, nullable=false, length=100)
    private String nome;

    @Column(name="QtEstq", nullable=false)
    private Integer quantidadeEstoque;

    @Column(name="VlUnit", nullable=false, precision=17, scale=2)
    private BigDecimal valorUnitario;

    public Produto() {
        super();
        nome = "";
        quantidadeEstoque = 0;
        valorUnitario = BigDecimal.ZERO;
    }

    public Produto(String nome, Integer quantidadeEstoque, String valorUnitario) {
        super();
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorUnitario = new BigDecimal(valorUnitario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
