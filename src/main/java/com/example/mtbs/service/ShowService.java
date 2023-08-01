package com.example.mtbs.service;

import com.example.mtbs.model.Show;
import com.example.mtbs.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public Show getShowById(Long show_id) {
        return showRepository.findById(show_id).get();
    }

    public Show updateShow(Show show) {
        return showRepository.save(show);
    }

    public void deleteShowById(Long show_id) {
        showRepository.deleteById(show_id);
    }
}
