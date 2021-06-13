package pl.springboot2.karoljanik.newsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.springboot2.karoljanik.newsapi.model.PersonInfo;
import pl.springboot2.karoljanik.newsapi.service.InfoService;

import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "http://localhost:4200")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @PostMapping
    public void insertInfo(PersonInfo personInfo) {
        infoService.addInfo(personInfo);
    }

    @GetMapping
    public List<PersonInfo> getAllInfos(){
        return infoService.getAllInfos();
    }

    @PutMapping(path = "{id}")
    public void editInfo(@PathVariable("id") int id, @RequestBody PersonInfo personInfo) {
        infoService.editInfo(id, personInfo);
    }
}
