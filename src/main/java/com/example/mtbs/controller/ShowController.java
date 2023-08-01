package com.example.mtbs.controller;

import com.example.mtbs.model.Show;
import com.example.mtbs.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

//    @GetMapping("/shows")
//    public String getShows(Model model) {
//        model.addAttribute("shows", showService.getAllShows());
//        return "shows";
//    }
//
//    @GetMapping("/admin/shows")
//    public String getAdminShows(Model model) {
//        model.addAttribute("shows", showService.getAllShows());
//        return "adminShows";
//    }
//
//    @GetMapping("/admin/shows/view/{show_id}")
//    public String viewAdminShow(@PathVariable Long show_id, Model model) {
//        model.addAttribute("show", showService.getShowById(show_id));
//        return "viewAdminShow";
//    }
//
//    @GetMapping("/admin/shows/new")
//    public String addShowForm(Model model) {
//        Show show = new Show();
//        model.addAttribute("show", show);
//        return "addShow";
//    }
//
//    @PostMapping("/admin/shows/new")
//    public String addShow(@ModelAttribute("show") Show show) {
//        showService.addShow(show);
//        return "redirect:/admin/shows";
//    }
//
//    @GetMapping("/admin/shows/update/{show_id}")
//    public String updateShowForm(@PathVariable Long show_id, Model model) {
//        model.addAttribute("show", showService.getShowById(show_id));
//        return "updateShow";
//    }
//
//    @PostMapping("/admin/shows/update/{show_id}")
//    public String updateShow(@PathVariable Long show_id, @ModelAttribute("show") Show show) {
//        Show existingshow = showService.getShowById(show_id);
//        existingshow.setShow_id(show_id);
//        existingshow.setShow_name(show.getShow_name());
//        existingshow.setLocation(show.getLocation());
//        showService.updateShow(existingshow);
//        return "redirect:/admin/shows";
//    }
//
//    @GetMapping("admin/shows/delete/{show_id}")
//    public String deleteShow(@PathVariable Long show_id) {
//        showService.deleteShowById(show_id);
//        return "redirect:/admin/shows";
//    }

}
