package br.com.fiap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="Item")
public class ItemPedido extends AbstractEntity implements Serializable {

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="PED_ID", nullable=false)
    private Pedido pedido;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="PRD_ID", nullable=false)
    private Produto produto;

    @Column(name="NrQtd", nullable=false, precision=9)
    private Integer quantidade;

    @Column(name="VlUnit", nullable=false, precision=17, scale=2)
    private BigDecimal valorUnitario;

    public ItemPedido() {
        super();
        this.pedido = null;
        this.produto = null;
        this.quantidade = 0;
        this.valorUnitario = BigDecimal.ZERO;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
