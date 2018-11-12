package com.service.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.pedido.domain.PedidoDomain;

public interface PedidoRepository extends JpaRepository<PedidoDomain, Long>{

}
