package com.service.pedido.modelsDto;

import java.io.Serializable;

public class PedidoDto implements Serializable{

	private static final long serialVersionUID = 4089970941204597683L;
	
	private Long id;
	private	Long id_cliente;
	private Long id_produto;
	private Integer qtd;
	
	public PedidoDto() {}
	public PedidoDto(Long id,Long id_cliente,Long id_produto,Integer qtd) {
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_produto = id_produto;
		this.qtd = qtd;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	@Override
	public String toString() {
		return "PedidoDto [id=" + id + ", id_cliente=" + id_cliente + ", id_produto=" + id_produto + ", qtd=" + qtd
				+ "]";
	}
	

}
