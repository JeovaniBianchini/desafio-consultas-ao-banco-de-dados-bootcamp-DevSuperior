package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dtos.ReviewDto;
import com.devsuperior.movieflix.dtos.UserDto;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    public ReviewDto insertReview(ReviewDto reviewDto){
        Movie movie = movieRepository.getOne(reviewDto.getMovieId());
        Review review = new Review();
        review.setText(reviewDto.getText());
        review.setMovie(movie);
        review = reviewRepository.save(review);
        UserDto userDto = userService.getProfile();
        return new ReviewDto(review, userDto);
    }
}
