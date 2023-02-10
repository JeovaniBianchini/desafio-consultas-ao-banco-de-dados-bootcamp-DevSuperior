package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dtos.MovieDto;
import com.devsuperior.movieflix.dtos.MovieDtoByGenre;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id){
        MovieDto dto = movieService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<MovieDtoByGenre>> findByGenre(
            @RequestParam(value = "genreId", defaultValue = "0")Long genreId,
            @PageableDefault(sort = "title", direction = Sort.Direction.ASC) Pageable pageable){
        Page<MovieDtoByGenre> list = movieService.findByGenre(genreId, pageable);
        return ResponseEntity.ok().body(list);

    }
}
