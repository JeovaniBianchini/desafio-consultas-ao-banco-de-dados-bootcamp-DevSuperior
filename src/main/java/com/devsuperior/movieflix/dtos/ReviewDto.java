package com.devsuperior.movieflix.dtos;

import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;

public class ReviewDto implements Serializable {

    private Long id;
    private String text;
    private Long movieId;
    private UserDto user;

    public ReviewDto(){
    }

    public ReviewDto(Long id, String text, Long movieId, UserDto user) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
        this.user = user;
    }

    public ReviewDto(Review review, UserDto dto) {
        id = review.getId();
        text = review.getText();
        movieId = review.getMovie().getId();
        user = dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
