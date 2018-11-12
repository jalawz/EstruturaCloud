package com.service.cliente.controllerDto;

import java.io.Serializable;

import com.service.cliente.modelsDto.ClienteDto;

public class ClienteDtoResponse implements Serializable{
	
	private static final long serialVersionUID = -783814211327085113L;
	
	private ClienteDto clienteDto;
	
	public ClienteDtoResponse () {}
	public ClienteDtoResponse (ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}
	public ClienteDto getClienteDto() {
		return clienteDto;
	}
	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}
	@Override
	public String toString() {
		return "ClienteDtoResponse [clienteDto=" + clienteDto + "]";
	}
	
	
}
