package com.produto.models;

import java.io.Serializable;

public class ProdutoDto implements Serializable {

	private static final long serialVersionUID = -6250955346122735818L;

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ProdutoDto [id=" + id + ", nome=" + nome + "]";
	}

}
