package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dtos.GenreDto;
import com.devsuperior.movieflix.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDto>> findAll(){
        List<GenreDto> dtoList = genreService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }
}
