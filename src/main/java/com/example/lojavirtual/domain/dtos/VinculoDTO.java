package com.example.lojavirtual.domain.dtos;

import java.io.Serializable;
public class VinculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer idPedido;
    protected Integer idCliente;

    public VinculoDTO(Integer idPedido, Integer idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
    }

    public VinculoDTO() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
