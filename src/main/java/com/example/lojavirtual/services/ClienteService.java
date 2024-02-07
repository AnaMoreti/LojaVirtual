package com.example.lojavirtual.services;

import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.dtos.ClienteDTO;
import com.example.lojavirtual.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) throws Exception {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new Exception(" Objeto não encontrado!" + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setIdCliente(null);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) throws Exception {
        objDTO.setIdCliente(id);
        Cliente oldObj = findById(id);
        oldObj = new Cliente(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) throws Exception {
        Cliente obj = findById(id);
        if (obj.getPedidos().size() > 0) {
            throw new DataIntegrityViolationException("Cliente tem pedido em aberto, não pode ser deletado");
        }
    }
}
