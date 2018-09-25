package com.ngiersz.collector.persistance;

import com.ngiersz.collector.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoviesReposotory extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitleAndYear(String title, String year);
}
