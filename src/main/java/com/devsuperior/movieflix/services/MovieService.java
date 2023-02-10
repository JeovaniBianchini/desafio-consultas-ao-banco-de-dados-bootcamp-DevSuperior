package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dtos.MovieDto;
import com.devsuperior.movieflix.dtos.MovieDtoByGenre;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public MovieDto findById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        Movie movie =  movieOptional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new MovieDto(movieOptional.get());
    }

    @Transactional(readOnly = true)
    public Page<MovieDtoByGenre> findByGenre(Long genreId, Pageable pageable){
        Genre genre = genreRepository.getOne(genreId);
        Page<Movie> pageDto = movieRepository.findAll(pageable);
        Page<MovieDtoByGenre> page = (genreId == 0) ? pageDto.map(x -> new MovieDtoByGenre(x)) : movieRepository.findByGenre(genre.getId(), pageable);
        return page;
    }
}
