package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRespository;
import com.devsuperior.dslist.repositories.GameRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRespository gameRespository;

    @Autowired
    private GameListRespository gameListRespository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> result = gameRespository.findAll();
        return result.stream().map(game -> new GameMinDto(game)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRespository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId){
        List<GameMinProjection> result = gameListRespository.searchByList(listId);
        return result.stream().map(gameMinProjection -> new GameMinDto(gameMinProjection)).toList();
    }

}
