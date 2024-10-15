package com.workintech.s17d2.rest;


import com.workintech.s17d2.Experience;
import com.workintech.s17d2.model.Developer;

import com.workintech.s17d2.tax.DeveloperTax;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DeveloperController {

   public  Map<Integer , Developer> developers;
    Taxable developerTax;


    @PostConstruct
    public void init(){
        developers=new HashMap<>();
    }


    public DeveloperController(Taxable developerTax) {
        this.developerTax =  developerTax;
    }


    @GetMapping("/developers")
    public List getDevelopers(){
        Set<Integer> keys = developers.keySet();
        List developersList = new ArrayList<>();
        for(Integer key : keys){
            developersList.add(developers.get(key));
        }
        return developersList;
    }


    @GetMapping("/developers/{id}")
    public Developer getDeveloper(@PathVariable int id){
        if (developers.containsKey(id)){
            return developers.get(id);
        }
        return null;
    }

    @PostMapping("/developers")
    public Developer  newDeveloper(@RequestBody Developer developer){
        int id = (int) developer.getId();
        String name = developer.getName();
        Experience experience = developer.getExperience();
        double salary = developer.getSalary();


        switch (experience) {
            case JUNIOR:
                salary -= developerTax.getSimpleTaxRate();
                break;
            case MID:
                salary -= developerTax.getMiddleTaxRate();
                break;
            case SENIOR:
                salary -= developerTax.getUpperTaxRate();
                break;
        }

        developers.put(id , new Developer(id , name , salary , experience));

        return developer;

    }


     @PutMapping("/developers/{id}")
    public Developer updateDeveloper(@PathVariable int id ,@RequestBody Developer developer){
        developers.put(id , developer);
        return developer;
     }


     @DeleteMapping("/developers/{id}")
    public Developer deleteDeveloper(@PathVariable int id){
        developers.remove(id);
        return developers.get(id);
     }





}
