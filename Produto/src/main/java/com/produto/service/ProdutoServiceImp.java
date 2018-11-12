package com.produto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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

		ProdutoDto dto = new ProdutoDto();

		produtoDomain.ifPresent(pd -> {
			dto.setId(pd.getId());
			dto.setNome(pd.getNome());
		});

		return dto;
	}

	@Override
	public ProdutoDto create(ProdutoDto produtoDto) {

		ProdutoDomain produtoDomain = new ProdutoDomain();
		
		produtoDomain.setNome(produtoDto.getNome());
		
		produtoDomain = this.produtoRepository.save(produtoDomain);

		produtoDto.setId(produtoDomain.getId());
		produtoDto.setNome(produtoDomain.getNome());

		return produtoDto;
	}

	@Override
	public ProdutoDto update(Long id, ProdutoDto produto) {

		Optional<ProdutoDomain> produtoDomain = this.produtoRepository.findById(id);

		ProdutoDto dto = new ProdutoDto();
		produtoDomain.ifPresent(pd -> {
			dto.setId(pd.getId());
			dto.setNome((produto.getNome() != null)?produto.getNome():pd.getNome());

			this.produtoRepository.save(pd);
		});

		return dto;
	}

	@Override
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		this.produtoRepository.deleteById(id);

	}

}
