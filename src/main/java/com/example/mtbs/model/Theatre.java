package com.example.mtbs.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="theatres")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatre_id;
    @Column(name = "theatre_name", nullable = false)
    private String theatre_name;
    private String location;

//    @ManyToMany(mappedBy = "movie_theatres")
    //Set<Movie> movies;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy="theatre",cascade = CascadeType.ALL)
//    private Set<Show> show;


    public Theatre() {
    }

    public Theatre(Long theatre_id, String theatre_name, String location, List<Movie> movie) {
        this.theatre_id = theatre_id;
        this.theatre_name = theatre_name;
        this.location = location;
    }

    public Long getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(Long theatre_id) {
        this.theatre_id = theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public void setTheatre_name(String theatre_name) {
        this.theatre_name = theatre_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Theatre{" +
                "theatre_id=" + theatre_id +
                ", theatre_name='" + theatre_name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
