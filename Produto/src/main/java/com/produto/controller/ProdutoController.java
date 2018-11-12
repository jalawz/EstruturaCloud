package com.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.controller.dto.ProdutoDtoResponse;
import com.produto.controller.dto.ProdutosDtoResponse;
import com.produto.modelsDto.ProdutoDto;
import com.produto.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<ProdutosDtoResponse> findAll() {
		List<ProdutoDto> produto = this.produtoService.findAll();
		return ResponseEntity.ok(new ProdutosDtoResponse(produto));
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ProdutoDtoResponse> find(@PathVariable(value = "id") Long id) {
		ProdutoDto produto = this.produtoService.find(id);
		return ResponseEntity.ok(new ProdutoDtoResponse(produto));
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<ProdutoDtoResponse> create(@RequestBody ProdutoDto produto){
		ProdutoDto produtoDto = this.produtoService.create(produto);
		return ResponseEntity.ok(new ProdutoDtoResponse(produtoDto));
	}	
	@ResponseBody
	public ResponseEntity<ProdutoDto> update(@PathVariable(value = "id") Long id, Error error) {

		ProdutoDto produto = this.produtoService.find(id);

		return new ResponseEntity<ProdutoDto>(produto, HttpStatus.OK);
	}
	@ResponseBody
	public void delete() {

	}
}
