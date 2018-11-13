package com.service.pedido.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.pedido.domain.PedidoDomain;
import com.service.pedido.modelsDto.PedidoDto;
import com.service.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public List<PedidoDto> findAll(){
		
		List<PedidoDomain> pedidoDomain = this.pedidoRepository.findAll();
		List<PedidoDto> pedidoDto = new ArrayList<>();
		
		for(PedidoDomain pd : pedidoDomain) {
			PedidoDto dto = new PedidoDto();
			
			dto.setId(pd.getId());
			dto.setId_cliente(pd.getId_cliente());
			dto.setId_produto(pd.getId_produto());
			dto.setQtd(pd.getQtd());
			
			pedidoDto.add(dto);
		}
		
		return pedidoDto;
	}
	
	public PedidoDto find(Long id) {
		
		Optional<PedidoDomain> pedidoDomain = this.pedidoRepository.findById(id);
		
		PedidoDto pedidoDto = new PedidoDto();
		
		pedidoDomain.ifPresent(pd -> {
			pedidoDto.setId(pd.getId());
			pedidoDto.setId_cliente(pd.getId_cliente());
			pedidoDto.setId_produto(pd.getId_produto());
			pedidoDto.setQtd(pd.getQtd());
		});
		return pedidoDto;
	}
	
	public PedidoDto create(PedidoDto pedido) {
		
		PedidoDomain pedidoDomain = new PedidoDomain();
		
		pedidoDomain.setId_cliente(pedido.getId_cliente());
		pedidoDomain.setId_produto(pedido.getId_produto());
		pedidoDomain.setQtd(pedido.getQtd());
		
		pedidoDomain = this.pedidoRepository.save(pedidoDomain);
		pedido.setId(pedidoDomain.getId());
		
		return pedido;
	}
	
	public PedidoDto update(Long id, PedidoDto pedido) {
		
		Optional<PedidoDomain> pedidoDomain = this.pedidoRepository.findById(id);
		
		PedidoDto pedidoDto = new PedidoDto();
		
		pedidoDomain.ifPresent(pd ->{
			pd.setId_cliente((pedido.getId_cliente() != null)?pedido.getId_cliente():pd.getId_cliente());
			pd.setId_produto((pedido.getId_produto() != null)?pedido.getId_produto():pd.getId_produto());
			pd.setQtd((pedido.getQtd() != null)?pedido.getQtd():pd.getQtd());
			
			pd = this.pedidoRepository.save(pd);
			
			pedidoDto.setId(pd.getId());
			pedidoDto.setId_cliente(pd.getId_cliente());
			pedidoDto.setId_produto(pd.getId_produto());
			pedidoDto.setQtd(pd.getQtd());
		});
		
		return pedidoDto;
	}
	public void delete(Long id) {
		
		this.pedidoRepository.deleteById(id);
	}
}
