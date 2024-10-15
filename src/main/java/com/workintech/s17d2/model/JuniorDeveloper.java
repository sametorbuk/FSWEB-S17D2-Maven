package com.workintech.s17d2.model;

import com.workintech.s17d2.Experience;
import org.springframework.stereotype.Component;


@Component
public class JuniorDeveloper extends Developer{
    public JuniorDeveloper(Experience experience, double salary, String name, int id) {
        super(id , name , salary , experience);
    }

    public JuniorDeveloper(int i, String testDeveloper, double v) {
        super();
    }
}
