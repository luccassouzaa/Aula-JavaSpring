package com.devk.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devk.dslist.entities.Game;
import com.devk.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
