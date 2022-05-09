package br.com.fiap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Ped")
public class Pedido extends AbstractEntity implements Serializable {

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="CLI_ID", nullable=false)
    private Cliente cliente;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="END_ID", nullable=false)
    private Endereco endereco;

    @Temporal(TemporalType.DATE)
    @Column(name="DtPed", nullable=false)
    private Date dataPedido;

    @Temporal(TemporalType.DATE)
    @Column(name="DtEntr", nullable=true)
    private Date dataEntrega;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="pedido")
    private List<ItemPedido> itens;

    @Column(name="VlPed", nullable=false, precision=17, scale=2)
    private BigDecimal valorPedido;

    public Pedido() {
        super();
        this.cliente = null;
        this.endereco = null;
        this.dataPedido = null;
        this.dataEntrega = null;
        this.valorPedido = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    public List<ItemPedido> getItens() { return itens; }

    public void setItens(List<ItemPedido> itens) { this.itens = itens; }

}
