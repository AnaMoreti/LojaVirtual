package com.example.lojavirtual.repositories;

import com.example.lojavirtual.domain.LojaVirtual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaVirtualRepository extends JpaRepository <LojaVirtual, Integer> {
}
