package com.service.cliente.controllerDto;

import java.io.Serializable;
import java.util.List;

import com.service.cliente.modelsDto.ClienteDto;

public class ClientesDtoResponse implements Serializable{
	
	private static final long serialVersionUID = 7240229779603020377L;
	
	
	private List<ClienteDto> clienteDto;
	
	public ClientesDtoResponse() {}
	public ClientesDtoResponse(List<ClienteDto> clienteDto) {
		this.clienteDto = clienteDto;
	}
	public List<ClienteDto> getClienteDto() {
		return clienteDto;
	}
	
	public void setClienteDto(List<ClienteDto> clienteDto) {
		this.clienteDto = clienteDto;
	}
	@Override
	public String toString() {
		return "ClientesDtoResponse [clienteDto=" + clienteDto + "]";
	}
	
	
	
}
