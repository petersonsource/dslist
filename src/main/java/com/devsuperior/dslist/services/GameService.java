package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game game = gameRepository.getById(id);
        return new GameDto(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> new GameMinDto(game)).
                collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long id) {
        List<GameMinProjection> games = gameRepository.searchByList(id);
        return games.stream()
                .map(game -> new GameMinDto(game)).
                collect(Collectors.toList());
    }

}
