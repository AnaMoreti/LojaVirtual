package com.example.lojavirtual.repositories;

import com.example.lojavirtual.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
