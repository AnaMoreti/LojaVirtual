package com.example.lojavirtual.repositories;

import com.example.lojavirtual.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PedidoRepository extends JpaRepository <Pedido,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Pedido p SET p.cliente.idCliente = :idCliente WHERE p.idPedido = :idPedido")
    void cadastraClienteDoPedido(Integer idPedido, Integer idCliente);

    }


