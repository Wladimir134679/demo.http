package com.example.http.demo.db;

import com.example.http.demo.rest.Visit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DBService {

    public ArrayList<Visit> visited;

    public DBService(){
        visited = new ArrayList<>();
    }

    public void add(String name, long time){
        add(new Visit(name, time));
    }

    public void add(Visit visit){
        visited.add(visit);
    }

    public ArrayList<Visit> get(long from, long to){
        ArrayList<Visit> visits = new ArrayList<>();
        for(Visit visit : visited){
            if(from <= visit.time && visit.time <= to)
                visits.add(visit);
        }
        return visits;
    }
}
