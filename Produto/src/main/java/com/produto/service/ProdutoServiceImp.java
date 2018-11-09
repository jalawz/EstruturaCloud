package com.produto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.domain.ProdutoDomain;
import com.produto.models.ProdutoDto;
import com.produto.repository.ProdutoRepository;

@Service
public class ProdutoServiceImp implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoServiceImp(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<ProdutoDto> findAll() {

		List<ProdutoDomain> produtoDomain = this.produtoRepository.findAll();

		List<ProdutoDto> produtos = new ArrayList<>();

		for (ProdutoDomain prod : produtoDomain) {
			ProdutoDto res = new ProdutoDto();
			res.setId(prod.getId());
			res.setNome(prod.getNome());

			produtos.add(res);
		}

		return produtos;
	}

	@Override
	public ProdutoDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoDto create(ProdutoDto produtoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoDto update(Long id, ProdutoDto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
