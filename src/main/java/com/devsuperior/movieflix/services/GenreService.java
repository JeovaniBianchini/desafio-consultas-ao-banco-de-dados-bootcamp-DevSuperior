package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dtos.GenreDto;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService{

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDto> findAll(){
        List<Genre> list = genreRepository.findAll();
        return list.stream().map(x -> new GenreDto(x)).collect(Collectors.toList());
    }
}
