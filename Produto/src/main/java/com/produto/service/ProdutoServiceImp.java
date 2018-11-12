package com.produto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.domain.ProdutoDomain;
import com.produto.modelsDto.ProdutoDto;
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
		Optional<ProdutoDomain> produtoDomain = this.produtoRepository.findById(id);
		
		System.out.println(produtoDomain);
		ProdutoDto produtoDto = new ProdutoDto();
	
		return produtoDto;
	}

	@Override
	public ProdutoDto create(ProdutoDto produtoDto) {
		ProdutoDomain pd = new ProdutoDomain();
		pd.setNome(produtoDto.getNome());
		
		this.produtoRepository.save(pd);
		
		return produtoDto;
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
