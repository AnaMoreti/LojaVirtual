package com.example.lojavirtual.services;

import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.Produto;
import com.example.lojavirtual.domain.dtos.ProdutoDTO;
import com.example.lojavirtual.repositories.ProdutoRepository;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ProdutoService {
    @Autowired
    public ProdutoRepository repository;

    public Produto findById(Integer id) throws Exception {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new Exception("Objeto não encontrado!" + id));
    }
public List<Produto> findAll(){
        return repository.findAll();
}
    public Produto create(ProdutoDTO objDTO){
        objDTO.setId(null);
        Produto newObj = new Produto(objDTO);
        return repository.save(newObj);
    }
    public Produto update (Integer id, @Valid ProdutoDTO objDTO) throws Exception{
        objDTO.setId(id);
        Produto oldObj = findById(id);
        oldObj = new Produto(objDTO);
        return repository.save(oldObj);
    }
    public void delete (Integer id) throws Exception{
        Produto obj = findById(id);
        throw new DataIntegrityViolationException("Produto deletado");
        }

}
