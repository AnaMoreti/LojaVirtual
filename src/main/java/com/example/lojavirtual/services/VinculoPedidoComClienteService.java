package com.example.lojavirtual.services;

import com.example.lojavirtual.repositories.PedidoRepository;
import com.example.lojavirtual.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class VinculoPedidoComClienteService {

    @Autowired
    public PedidoRepository repository;


    public void vincularPedidoComClienteService(Integer idPedido, Integer idCliente) {

        repository.cadastraClienteDoPedido(idPedido, idCliente);

    }
}
