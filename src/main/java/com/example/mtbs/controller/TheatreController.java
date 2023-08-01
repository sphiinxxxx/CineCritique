package com.example.mtbs.controller;

import com.example.mtbs.model.Theatre;
import com.example.mtbs.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class TheatreController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }



    @GetMapping("/theatres/")
    public String getTheatres(Model model) {
        model.addAttribute("theatres", theatreService.getAllTheatres());
        return "theatres";
    }

    @GetMapping("/admin/theatres")
    public String getAdminTheatres(Model model) {
        model.addAttribute("theatres", theatreService.getAllTheatres());
        return "adminTheatres";
    }

    @GetMapping("/admin/theatres/view/{theatre_id}")
    public String viewAdminTheatre(@PathVariable Long theatre_id, Model model) {
        model.addAttribute("theatre", theatreService.getTheatreById(theatre_id));
        return "viewAdminTheatre";
    }

    @GetMapping("/admin/theatres/new")
    public String addTheatreForm(Model model) {
        Theatre theatre = new Theatre();
        model.addAttribute("theatre", theatre);
        return "addTheatre";
    }

    @PostMapping("/admin/theatres/new")
    public String addTheatre(@ModelAttribute("theatre") Theatre theatre) {
        theatreService.addTheatre(theatre);
        return "redirect:/admin/theatres";
    }

    @GetMapping("/admin/theatres/update/{theatre_id}")
    public String updateTheatreForm(@PathVariable Long theatre_id, Model model) {
        model.addAttribute("theatre", theatreService.getTheatreById(theatre_id));
        return "updateTheatre";
    }

    @PostMapping("/admin/theatres/update/{theatre_id}")
    public String updateTheatre(@PathVariable Long theatre_id, @ModelAttribute("theatre") Theatre theatre) {
        Theatre existingtheatre = theatreService.getTheatreById(theatre_id);
        existingtheatre.setTheatre_id(theatre_id);
        existingtheatre.setTheatre_name(theatre.getTheatre_name());
        existingtheatre.setLocation(theatre.getLocation());
        theatreService.updateTheatre(existingtheatre);
        return "redirect:/admin/theatres";
    }

    @GetMapping("admin/theatres/delete/{theatre_id}")
    public String deleteTheatre(@PathVariable Long theatre_id) {
        theatreService.deleteTheatreById(theatre_id);
        return "redirect:/admin/theatres";
    }

}
