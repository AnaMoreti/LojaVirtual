package com.example.lojavirtual.domain.dtos;
import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.Pedido;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer idCliente;
    @NotNull(message = "O campo NOME é requerido.")
    protected String nome;
    @NotNull(message = "O campo TELEFONE é requerido.")
    protected String telefone;
    @NotNull(message = "O campo EMAIL é requerido.")
    protected String email;
    @NotNull(message = "O campo ENDERECO é requerido.")
    protected String endereco;
    private List<Pedido> pedidos = new ArrayList<>();

    public ClienteDTO(Cliente obj) {
        this.idCliente = obj.getIdCliente();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.endereco = obj.getEndereco();
        this.pedidos = obj.getPedidos();
    }

    public ClienteDTO() {

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
