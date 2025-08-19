package br.dev.nathan.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.nathan.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
