package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dtos.MovieDto;
import com.devsuperior.movieflix.dtos.MovieDtoByGenre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT new com.devsuperior.movieflix.dtos.MovieDtoByGenre(m.id, m.title, m.subTitle, m.year, m.imgUrl) FROM Movie m WHERE m.genre.id = :genreId")
    Page<MovieDtoByGenre> findByGenre(Long genreId, Pageable pageable);


}
