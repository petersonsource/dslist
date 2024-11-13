package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDto findById(Long id){
        GameList gameList= gameListRepository.getById(id);
        return new GameListDto(gameList);
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> gamesList = gameListRepository.findAll();
        return gamesList.stream()
                .map(gameList -> new GameListDto(gameList)).
                collect(Collectors.toList());
    }

}
