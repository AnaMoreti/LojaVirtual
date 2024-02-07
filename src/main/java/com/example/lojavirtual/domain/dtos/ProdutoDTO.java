package com.example.lojavirtual.domain.dtos;

import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.Produto;
import com.example.lojavirtual.domain.enums.ProdutoEstoque;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O campo NOME é requerido")
    protected String nome;
    @NotNull(message = "O campo DESCRICAO é requerido")
    protected String descricao;
    @NotNull(message = "O campo PRECO é requerido")
    protected Float precoProduto;
    protected ProdutoEstoque quantidadeEstoqueProduto;
    private Pedido pedido;


    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.pedido = obj.getPedido();

        this.nome = obj.getNome();
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
