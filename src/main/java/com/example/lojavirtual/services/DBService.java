package com.example.lojavirtual.services;

import com.example.lojavirtual.domain.Cliente;
import com.example.lojavirtual.domain.LojaVirtual;
import com.example.lojavirtual.domain.Pedido;
import com.example.lojavirtual.domain.Produto;
import com.example.lojavirtual.domain.enums.ProdutoEstoque;
import com.example.lojavirtual.domain.enums.Status;
import com.example.lojavirtual.repositories.ClienteRepository;
import com.example.lojavirtual.repositories.LojaVirtualRepository;
import com.example.lojavirtual.repositories.PedidoRepository;
import com.example.lojavirtual.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    LojaVirtualRepository lojaVirtualRepository;
    @Autowired
    PedidoRepository pedidoRepository;


    @Transactional
    public void instanciaDB() {

        LojaVirtual lj1 = new LojaVirtual(1, "TOPGame", "43243240789", "rua amador", "game@email");
        LojaVirtual lj2 = new LojaVirtual(2, "BelezaWEB", "432687324", "rua luis", "beleza@email");
        LojaVirtual lj3 = new LojaVirtual(3, "ModaWEB", "4324645642", "rua leonor", "moda@email");
        LojaVirtual lj4 = new LojaVirtual(4, "PapelariaWEB", "43243423", "rua antonio", "papelaria@email");
        Produto pro1 = new Produto(null, null, "Mario", "JOGO", 100, ProdutoEstoque.PRODUTO_ESTOQUE);
        Produto pro2 = new Produto(null, null, "Jogo", "Mario", 100, ProdutoEstoque.PRODUTO_ESGOTADO);
        Produto pro3 = new Produto(null, null, "Jogo", "Mario", 100, ProdutoEstoque.PRODUTO_ESGOTADO);
        Produto pro4 = new Produto(null, null, "Jogo", "Mario", 100, ProdutoEstoque.PRODUTO_ESTOQUE);
        Pedido p1 = new Pedido(null, LocalDate.now(), Status.ABERTO, 1, 3, Arrays.asList(pro1), null);
        Pedido p2 = new Pedido(null, LocalDate.now(), Status.FINALIZADO, 1, 3, Arrays.asList(pro2), null);
        Pedido p3 = new Pedido(null, LocalDate.now(), Status.ANDAMENTO, 1, 3, Arrays.asList(pro3), null);
        Pedido p4 = new Pedido(null, LocalDate.now(), Status.ABERTO, 1, 3, Arrays.asList(pro4), null);
        Cliente c1 = new Cliente(null, "Carlos", "4332231990", "carlos@email.com", "Rua Ermida", Arrays.asList(p1));
        Cliente c2 = new Cliente(null, "Janaina", "4332231990", "janaina@email.com", "Rua Ermida", Arrays.asList(p2));
        Cliente c3 = new Cliente(null, "Claudia", "4332231990", "claudia@email.com", "Rua Ermida", Arrays.asList(p3));
        Cliente c4 = new Cliente(null, "Lucas", "4332231990", "lucas@email.com", "Rua Ermida", Arrays.asList(p4));

        lojaVirtualRepository.saveAll(Arrays.asList(lj1, lj2, lj3, lj4));
        clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4));





    }
}