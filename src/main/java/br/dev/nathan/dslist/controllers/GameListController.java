package br.dev.nathan.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.nathan.dslist.dto.GameDTO;
import br.dev.nathan.dslist.dto.GameListDTO;
import br.dev.nathan.dslist.services.GameListService;

@RestController
@RequestMapping(value = "lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

}
