package com.example.mtbs.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long show_id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    private Date date;
    private Time time;

    public Show() {
    }

    public Show(Long show_id, Movie movie, Theatre theatre, Date date, Time time) {
        this.show_id = show_id;
        this.movie = movie;
        this.theatre = theatre;
        this.date = date;
        this.time = time;
    }

    public Long getShow_id() {
        return show_id;
    }

    public void setShow_id(Long show_id) {
        this.show_id = show_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Show{" +
                "show_id=" + show_id +
                ", movie=" + movie +
                ", theatre=" + theatre +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
