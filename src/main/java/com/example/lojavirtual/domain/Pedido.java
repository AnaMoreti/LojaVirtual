package com.example.lojavirtual.domain;

import com.example.lojavirtual.domain.dtos.PedidoDTO;
import com.example.lojavirtual.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDoPedido = LocalDate.now();
    private Status status;
    private int quantidade;
    private int precoUnitario;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Produto> produtos;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Integer idPedido, LocalDate dataDoPedido, Status status, int quantidade, int precoUnitario, List<Produto> produtos, Cliente cliente) {
        this.idPedido = idPedido;
        this.dataDoPedido = dataDoPedido;
        this.status = status;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;

        this.produtos = produtos;
        this.cliente = cliente;
    }

    public Pedido(PedidoDTO objDTO) {
        this.idPedido = objDTO.getIdPedido();
        this.dataDoPedido = objDTO.getDataDoPedido();
        this.status = objDTO.getStatus();
        this.quantidade = objDTO.getQuantidade();
        this.precoUnitario = objDTO.getPrecoUnitario();

        this.cliente = objDTO.getCliente();
        this.produtos = objDTO.getProdutos();
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(LocalDate dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(int precoUnitario) {
        this.precoUnitario = precoUnitario;
    }




    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
