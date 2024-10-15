package com.workintech.s17d2.model;

import com.workintech.s17d2.Experience;
import org.springframework.stereotype.Component;

@Component
public class MidDeveloper extends Developer{
    public MidDeveloper(Experience experience, double salary, String name, int id) {
        super(id , name , salary , experience);
    }

    public MidDeveloper(int i, String testDeveloper, double v) {
    }
}
