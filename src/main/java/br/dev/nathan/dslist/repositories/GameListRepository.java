package br.dev.nathan.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.nathan.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
