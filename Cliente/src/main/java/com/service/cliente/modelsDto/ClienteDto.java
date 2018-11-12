package com.service.cliente.modelsDto;

import java.io.Serializable;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = -7986733340324349463L;
	
	private Long id;
	private String nome;
	private String cpf;
	private Integer idade;
	
	public ClienteDto () {}
	
	public ClienteDto (Long id, String nome, String cpf, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + "]";
	}
	
	

}
