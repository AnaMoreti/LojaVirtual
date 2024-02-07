package com.example.lojavirtual.domain;


import com.example.lojavirtual.domain.dtos.ProdutoDTO;
import com.example.lojavirtual.domain.enums.ProdutoEstoque;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    private String nome;
    private String descricao;
    private Float precoProduto;
    private ProdutoEstoque quantidadeEstoqueProduto;

    public Produto() {
    }

    public Produto(Integer id, Pedido pedido, String nome, String descricao, float precoProduto, ProdutoEstoque quantidadeEstoqueProduto) {
        this.id = id;
        this.pedido = pedido;
        this.nome = nome;
        this.descricao = descricao;
        this.precoProduto = precoProduto;
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }
    public Produto(ProdutoDTO obj) {
        this.id = obj.getId();
        this.pedido = obj.getPedido();
        this.nome= obj.getNome();
        this.descricao = obj.getDescricao();
        this.precoProduto = obj.getPrecoProduto();
        this.quantidadeEstoqueProduto = obj.getQuantidadeEstoqueProduto();
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public ProdutoEstoque getQuantidadeEstoqueProduto() {
        return quantidadeEstoqueProduto;
    }

    public void setQuantidadeEstoqueProduto(ProdutoEstoque quantidadeEstoqueProduto) {
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }

}