package com.service.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.cliente.domain.ClienteDomain;

public interface ClienteRepository extends JpaRepository<ClienteDomain, Long> {

}
