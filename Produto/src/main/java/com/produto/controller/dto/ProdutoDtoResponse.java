package com.produto.controller.dto;

import java.io.Serializable;

import com.produto.modelsDto.ProdutoDto;

public class ProdutoDtoResponse implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private ProdutoDto produto = new ProdutoDto();
	
	
	public ProdutoDtoResponse() {}
			
	public ProdutoDtoResponse(ProdutoDto produto) {
		this.produto = produto;
	}
	

	public ProdutoDto getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
	

	@Override
	public String toString() {
		return "ProdutoDtoResponse [produto=" + produto + "]";
	}
	
	
}
