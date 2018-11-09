package com.produto.controller.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.produto.modelsDto.ProdutoDto;

public class ProdutosDtoResponse implements Serializable {

	private static final long serialVersionUID = -7543572314200904293L;

	List<ProdutoDto> produtos = new ArrayList<>();

	public ProdutosDtoResponse() {
	}

	public ProdutosDtoResponse(List<ProdutoDto> produtos) {
		this.produtos = produtos;
	}

	public List<ProdutoDto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "ProdutosDtoResponse [produto=" + produtos + "]";
	}

}
