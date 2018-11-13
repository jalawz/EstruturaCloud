package com.service.pedido.controller;

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

import com.service.pedido.controllerDto.PedidoDtoResponse;
import com.service.pedido.controllerDto.PedidosDtoResponse;
import com.service.pedido.modelsDto.PedidoDto;
import com.service.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<PedidosDtoResponse> findAll() {

		List<PedidoDto> pedidoDto = this.pedidoService.findAll();

		return ResponseEntity.ok(new PedidosDtoResponse(pedidoDto));
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<PedidoDtoResponse> find(@PathVariable(value = "id") Long id) {
		PedidoDto pedidoDto = this.pedidoService.find(id);
		return ResponseEntity.ok(new PedidoDtoResponse(pedidoDto));
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<PedidoDtoResponse> create(@RequestBody PedidoDto pedido) {
		PedidoDto pedidoDto = this.pedidoService.create(pedido);
		return ResponseEntity.ok(new PedidoDtoResponse(pedidoDto));
	}

	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<PedidoDtoResponse> update(@PathVariable(value = "id") Long id,
			@RequestBody PedidoDto pedido) {
		
		PedidoDto pedidoDto = this.pedidoService.update(id, pedido);
		
		return ResponseEntity.ok(new PedidoDtoResponse(pedidoDto));
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.pedidoService.delete(id);
	}

}
