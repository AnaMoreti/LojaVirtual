package com.example.lojavirtual.resources;

import com.example.lojavirtual.domain.dtos.VinculoDTO;
import com.example.lojavirtual.services.VinculoPedidoComClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/vinculo")
public class VincularPedidoComClienteResource {
    @Autowired
    private VinculoPedidoComClienteService service;

    @PutMapping
    public ResponseEntity<String> vinculo(@Valid @RequestBody VinculoDTO objDTO) throws Exception {

       service.vincularPedidoComClienteService(objDTO.getIdPedido(),objDTO.getIdCliente());
        return ResponseEntity.ok().body("Pedido atualizado com sucesso");
    }
}