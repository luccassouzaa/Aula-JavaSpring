package com.devk.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devk.dslist.dto.GameDTO;
import com.devk.dslist.dto.GameMinDTO;
import com.devk.dslist.entities.Game;
import com.devk.dslist.projections.GameMinProjection;
import com.devk.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) // assegurando que nao irei fazer nenhuma operação de escrita.
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		//CASO O ID NAO EXISTA, SERÁ FEITO UM TRATAMENTO DE EXCESSÕES 
	
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
