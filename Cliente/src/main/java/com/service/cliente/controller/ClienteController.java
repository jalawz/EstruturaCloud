package com.service.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.cliente.controllerDto.ClienteDtoResponse;
import com.service.cliente.controllerDto.ClientesDtoResponse;
import com.service.cliente.modelsDto.ClienteDto;
import com.service.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<ClientesDtoResponse> findAll() {
		List<ClienteDto> clienteDto = this.clienteService.findAll();
		return ResponseEntity.ok(new ClientesDtoResponse(clienteDto));
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<ClienteDtoResponse> find(@PathVariable(value = "id") Long id) {
		ClienteDto clienteDto = this.clienteService.find(id);
		
		return ResponseEntity.ok(new ClienteDtoResponse(clienteDto));

	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<ClienteDtoResponse> create(@RequestBody ClienteDto cliente) {
		
		ClienteDto clienteDto = this.clienteService.create(cliente);

		return ResponseEntity.ok(new ClienteDtoResponse(clienteDto));
	}
	
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<ClienteDtoResponse> update(@PathVariable(value = "id") Long id,@RequestBody ClienteDto cliente){

		ClienteDto clienteDto = this.clienteService.update(id,cliente);
		return ResponseEntity.ok(new ClienteDtoResponse(clienteDto));
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id")Long id){
		this.clienteService.delete(id);
	}
}
