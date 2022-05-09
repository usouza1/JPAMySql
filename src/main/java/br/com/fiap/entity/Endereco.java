package br.com.fiap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="End")
public class Endereco extends AbstractEntity implements Serializable {

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CLI_ID", nullable=false)
    private Cliente cliente;

    @Column(name="TxLog", nullable=false, length=100)
    private String logradouro;

    @Column(name="TxCmpl", nullable=false, length=100)
    private String complemento;

    @Column(name="TxBai", nullable=false, length=100)
    private String bairro;

    @Column(name="TxCid", nullable=false, length=100)
    private String cidade;

    @Column(name="TxUf", nullable=false, length=2)
    private String uf;

    @Column(name="NrCep", nullable=false, precision=9)
    private Integer cep;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="endereco")
    private List<Pedido> pedidos;

    public Endereco(String logradouro, String complemento, String bairro, String cidade, String uf, Integer cep) {
        super();
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.cliente = null;
        this.pedidos = null;
    }

    public Endereco() {
        super();
        this.logradouro = "";
        this.complemento = "";
        this.bairro = "";
        this.cidade = "";
        this.uf = "";
        this.cep = 0;
        this.cliente = null;
        this.pedidos = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

}
