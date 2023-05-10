package com.devk.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devk.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
