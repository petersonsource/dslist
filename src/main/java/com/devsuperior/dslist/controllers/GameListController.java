package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.dto.ReplacementoDto;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDto findById(@PathVariable(value = "id") Long id){
       return gameListService.findById(id);
    }


    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDto> findByList(@PathVariable(value = "id") Long id){
        return gameService.findByList(id);
    }

    @PostMapping(value = "/{id}/replacement")
    public void findByList(@PathVariable(value = "id") Long id, @RequestBody ReplacementoDto body){
        gameListService.move(id, body.getSourceIndex(), body.getDestinationIndex());
    }

}
