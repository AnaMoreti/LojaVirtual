package com.example.lojavirtual.services;

import com.example.lojavirtual.domain.LojaVirtual;
import com.example.lojavirtual.domain.dtos.LojaVirtualDTO;
import com.example.lojavirtual.repositories.LojaVirtualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class LojaVirtualService {
    @Autowired
    private LojaVirtualRepository repository;

    public LojaVirtual findById (Integer id) throws Exception{
        Optional<LojaVirtual> obj = repository.findById(id);
        return obj.orElseThrow(() -> new Exception(" Objeto não encontrado!" + id));
    }
    public LojaVirtual create (LojaVirtualDTO objDTO){
        objDTO.setId(null);
        LojaVirtual newObj = new LojaVirtual(objDTO);
        return repository.save(newObj);

    }
    public LojaVirtual update (Integer id, @Valid LojaVirtualDTO objDTO) throws Exception{
        objDTO.setId(id);
        LojaVirtual oldObj = findById(id);
        oldObj = new LojaVirtual(objDTO);
        return repository.save(oldObj);
    }
    public void delete (Integer id) throws Exception{
        LojaVirtual obj = findById(id);
            throw new DataIntegrityViolationException("Loja virtual nao pode ser deletada, pois existe pedido em aberto");

        }



    public List<LojaVirtual> findAll() {
        return repository.findAll();
    }
}
