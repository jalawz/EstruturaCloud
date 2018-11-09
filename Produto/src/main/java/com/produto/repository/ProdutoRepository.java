package com.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.domain.ProdutoDomain;

public interface ProdutoRepository extends JpaRepository<ProdutoDomain, Long>{

}
