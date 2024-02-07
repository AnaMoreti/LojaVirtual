package com.example.lojavirtual.services;

import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.dtos.PedidoDTO;
import com.example.lojavirtual.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido findById(Integer id) throws Exception {
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(() -> new Exception("Objeto nao encontrado!" + id));
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Pedido create(PedidoDTO objDTO) {
        objDTO.setIdPedido(null);
        Pedido newObj = new Pedido(objDTO);
        return repository.save(newObj);
    }

    public Pedido update(Integer id, PedidoDTO objDTO) throws Exception {
        objDTO.setIdPedido(id);
        Pedido oldObj = findById(id);
        oldObj = new Pedido(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) throws Exception {
        Pedido obj = findById(id);
        throw new DataIntegrityViolationException("Pedido deletado");

    }
}

