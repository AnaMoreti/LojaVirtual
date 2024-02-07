package com.example.lojavirtual.domain.dtos;


import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.Produto;
import com.example.lojavirtual.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer idPedido;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataDoPedido = LocalDate.now();
    @NotNull(message = "O campo STATUS é requerido")
    private Status status;

    private int quantidade;

    private int precoUnitario;



    private Cliente cliente;
    private List<Produto> produtos;

    public PedidoDTO(Pedido obj) {
        this.idPedido = obj.getIdPedido();
        this.dataDoPedido = obj.getDataDoPedido();
        this.status = obj.getStatus();
        this.quantidade = obj.getQuantidade();
        this.precoUnitario = obj.getPrecoUnitario();

        this.cliente = obj.getCliente();
        this.produtos = obj.getProdutos();


    }

    public PedidoDTO(Integer idPedido, LocalDate dataDoPedido, Status status, int quantidade, int precoUnitario, Cliente cliente, List<Produto> produtos) {
        this.idPedido = idPedido;
        this.dataDoPedido = dataDoPedido;
        this.status = status;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;

        this.cliente = cliente;
        this.produtos = produtos;
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


        public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
