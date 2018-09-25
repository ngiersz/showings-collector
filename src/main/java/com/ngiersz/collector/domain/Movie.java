package com.ngiersz.collector.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String year;
    Integer duration;

    @Override
    public String toString() {
        return id + ": " + title + " (" + year + "), " + duration + "min";
    }
}
