package com.ngiersz.collector.service;

import com.ngiersz.collector.domain.Movie;
import com.ngiersz.collector.domain.Show;
import com.ngiersz.collector.persistance.MoviesReposotory;
import com.ngiersz.collector.persistance.ShowingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShowingsService {

    @Autowired
    private MoviesReposotory moviesReposotory;

    @Autowired
    private ShowingsRepository showingsRepository;

    public Show findById(Long id) {
        Optional<Show> show = showingsRepository.findById(id);
        if(show.isPresent()) {
            return show.get();
        }
        throw new NoSuchElementException();
    }

    public void save(Show show, Movie movie) {
        if(!moviesReposotory.findByTitleAndYear(movie.getTitle(), movie.getYear()).isPresent()) {
            moviesReposotory.save(movie);
        }
        show.setMovieID(moviesReposotory.findByTitleAndYear(movie.getTitle(), movie.getYear()).get().getId());
        showingsRepository.save(show);
    }

    public List<Show> findAll() {
        return showingsRepository.findAll();
    }
}
