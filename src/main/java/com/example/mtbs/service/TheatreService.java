package com.example.mtbs.service;

import com.example.mtbs.model.Theatre;
import com.example.mtbs.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatreById(Long theatre_id) {
        return theatreRepository.findById(theatre_id).get();
    }

    public Theatre updateTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheatreById(Long theatre_id) {
        theatreRepository.deleteById(theatre_id);
    }
}
