package com.ngiersz.collector.persistance;

import com.ngiersz.collector.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingsRepository extends JpaRepository<Show, Long> {
}
