package com.example.lojavirtual.resources;


import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.LojaVirtual;
import com.example.lojavirtual.domain.dtos.ClienteDTO;
import com.example.lojavirtual.domain.dtos.LojaVirtualDTO;
import com.example.lojavirtual.services.ClienteService;
import com.example.lojavirtual.services.LojaVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/loja")
public class LojaVirtualResource {
    @Autowired
    private LojaVirtualService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<LojaVirtualDTO> findById(@PathVariable Integer id) throws Exception {
        LojaVirtual obj = service.findById(id);
        return ResponseEntity.ok().body(new LojaVirtualDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<LojaVirtualDTO>> findAll() {
        List<LojaVirtual> list = service.findAll();
        List<LojaVirtualDTO> listDTO = list.stream().map(obj -> new LojaVirtualDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<LojaVirtualDTO> create(@Valid @RequestBody LojaVirtualDTO objDTO) {
        LojaVirtual newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().body("Cliente removido com sucesso");
    }
}
