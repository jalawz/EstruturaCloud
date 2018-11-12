package com.service.cliente.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.cliente.domain.ClienteDomain;
import com.service.cliente.modelsDto.ClienteDto;
import com.service.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<ClienteDto> findAll() {

		List<ClienteDomain> clienteDomain = this.clienteRepository.findAll();

		List<ClienteDto> clienteDto = new ArrayList<>();

		for (ClienteDomain cliDto : clienteDomain) {

			ClienteDto dto = new ClienteDto();

			dto.setId(cliDto.getId());
			dto.setNome(cliDto.getNome());
			dto.setIdade(cliDto.getIdade());
			dto.setCpf(cliDto.getCpf());

			clienteDto.add(dto);
		}
		return clienteDto;
	}

	public ClienteDto find(Long id) {

		Optional<ClienteDomain> clienteDto = this.clienteRepository.findById(id);

		ClienteDto cliente = new ClienteDto();

		clienteDto.ifPresent(cp -> {
			cliente.setId(cp.getId());
			cliente.setNome(cp.getNome());
			cliente.setIdade(cp.getIdade());
			cliente.setCpf(cp.getCpf());
		});
		return cliente;
	}

	public ClienteDto create(ClienteDto cliente) {
		
		ClienteDomain clienteDomain = new ClienteDomain();
		
		clienteDomain.setNome(cliente.getNome());
		clienteDomain.setIdade(cliente.getIdade());
		clienteDomain.setCpf(cliente.getCpf());
		
		clienteDomain = this.clienteRepository.save(clienteDomain);

		cliente.setId(clienteDomain.getId());
		
		return cliente;
	}

	public ClienteDto update(Long id, ClienteDto cliente) {
		
		Optional<ClienteDomain> clienteDomain = this.clienteRepository.findById(id);
		
		ClienteDto clienteDto = new ClienteDto();
		
		clienteDomain.ifPresent(cd -> {
			clienteDto.setId(cd.getId());
			
			clienteDto.setNome((cliente.getNome() != null)?cliente.getNome():cd.getNome());
			
			clienteDto.setIdade((cliente.getIdade() != null)?cliente.getIdade():cd.getIdade());
			
			clienteDto.setCpf((cliente.getCpf() != null)?cliente.getCpf():cd.getCpf());
			
			this.clienteRepository.save(cd);
		});
		
		return clienteDto;
	}

	public void delete(Long id) {
		this.clienteRepository.deleteById(id);
	}
}
