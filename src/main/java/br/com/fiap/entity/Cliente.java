package br.com.fiap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Cli")
public class Cliente extends AbstractEntity implements Serializable {

    @Column(name="NmCli", nullable=false, length=100)
    private String nome;

    @Column(name="NrCpf", unique=true, nullable=false, precision=12)
    private BigDecimal cpf;

    @Column(name="TxEmail", unique=true, nullable=false, length=100 )
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
    private List<Carrinho> carrinhos;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
    private List<Pedido> pedidos;

    public Cliente() {
        super();
        this.nome = "";
        this.cpf = BigDecimal.ZERO;
        this.email = "";
        this.enderecos = new ArrayList<>();
        this.carrinhos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String nome, Long cpf, String email) {
        super();
        this.nome = nome;
        this.cpf = new BigDecimal(cpf);
        this.email = email;
        this.enderecos = new ArrayList<>();
        this.carrinhos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getCpf() {
        return cpf;
    }

    public void setCpf(BigDecimal cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() { return enderecos; }

    public void setEnderecos(List<Endereco> enderecos) { this.enderecos = enderecos; }

    public List<Carrinho> getCarrinhos() { return carrinhos; }

    public void setCarrinhos(List<Carrinho> carrinhos) { this.carrinhos = carrinhos; }

    public List<Pedido> getPedidos() { return pedidos; }

    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }

}
