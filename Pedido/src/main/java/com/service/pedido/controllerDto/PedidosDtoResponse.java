package com.service.pedido.controllerDto;

import java.io.Serializable;
import java.util.List;

import com.service.pedido.modelsDto.PedidoDto;

public class PedidosDtoResponse implements Serializable{


	private static final long serialVersionUID = -8834327201898629642L;
	
	private List<PedidoDto> pedidosDto;
	
	public PedidosDtoResponse() {}
	
	public PedidosDtoResponse(List<PedidoDto> pedidosDto) {
		this.pedidosDto = pedidosDto;
	}
	public List<PedidoDto> getPedidosDto() {
		return pedidosDto;
	}
	public void setPedidosDto(List<PedidoDto> pedidosDto) {
		this.pedidosDto = pedidosDto;
	}
	@Override
	public String toString() {
		return "PedidosDtoResponse [pedidosDto=" + pedidosDto + "]";
	}
	
	
}
