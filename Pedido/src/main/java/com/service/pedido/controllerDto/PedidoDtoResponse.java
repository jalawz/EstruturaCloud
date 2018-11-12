package com.service.pedido.controllerDto;

import com.service.pedido.modelsDto.PedidoDto;

public class PedidoDtoResponse {
	
	private PedidoDto pedidoDto;
	
	public PedidoDtoResponse() {}
	public PedidoDtoResponse(PedidoDto pedidoDto) {
		this.pedidoDto = pedidoDto;
	}
	public PedidoDto getPedidoDto() {
		return pedidoDto;
	}
	public void setPedidoDto(PedidoDto pedidoDto) {
		this.pedidoDto = pedidoDto;
	}
	@Override
	public String toString() {
		return "PedidoDtoResponse [pedidoDto=" + pedidoDto + "]";
	}
	

}
