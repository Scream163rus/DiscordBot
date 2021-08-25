package ru.zagrebin.diploma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.zagrebin.diploma.models.Bunker;
import ru.zagrebin.diploma.repository.BunkerRepo;


@Controller
public class MainController {
    private BunkerRepo bunkerRepo;
    @Autowired
    public MainController(BunkerRepo bunkerRepo){
        this.bunkerRepo = bunkerRepo;
    }
    @GetMapping("/add")
    public String main(Model model){
        Iterable<Bunker> bunker = bunkerRepo.findAll();
        model.addAttribute("bunker",bunker);
        return "bunker_add";
    }
    @PostMapping("/add")
    public String add(Bunker bunker){
        bunkerRepo.save(bunker);
        return "redirect:/add";
    }
    @PostMapping("/{id}/remove")
    public String delete(@PathVariable(value = "id") long id){
        bunkerRepo.deleteById(id);
        return "redirect:/add";
    }

}
