package com.produto.service;

import java.util.List;

import com.produto.models.ProdutoDto;


public interface ProdutoService {
	
	public List<ProdutoDto> findAll();
	
	public ProdutoDto find(Long id);
	
	public ProdutoDto create(ProdutoDto produtoDto);
	
	public ProdutoDto update(Long id,ProdutoDto produto);
	
	public void delete(Long id);
}
