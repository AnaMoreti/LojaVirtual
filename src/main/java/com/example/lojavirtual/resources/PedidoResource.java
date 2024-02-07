package com.example.lojavirtual.resources;

import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.dtos.PedidoDTO;
import com.example.lojavirtual.services.PedidoService;
import com.example.lojavirtual.services.VinculoPedidoComClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
    @Autowired
    private PedidoService service;

    @Autowired
    private VinculoPedidoComClienteService vinculoPedidoComClienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Integer id) throws Exception {
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(new PedidoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        List<Pedido> list = service.findAll();
        List<PedidoDTO> listDTO = list.stream().map(PedidoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoDTO objDTO) {
        Pedido newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getIdPedido()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().body("Cliente removido com sucesso");
    }
}

