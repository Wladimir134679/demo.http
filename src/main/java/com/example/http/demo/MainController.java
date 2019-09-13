package com.example.http.demo;

import com.example.http.demo.data.PostVisitedLinks;
import com.example.http.demo.data.ResponseGetVisitedDomains;
import com.example.http.demo.data.ResponsePostVisitedLinks;
import com.example.http.demo.db.DBService;
import com.example.http.demo.rest.Visit;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@RestController
public class MainController {

    @Resource
    private DBService dbService;

    @PostMapping(path = "/visited_links")
    public ResponsePostVisitedLinks postVisitedLinks(@RequestBody PostVisitedLinks post){
        for(String s : post.links){
            dbService.add(s, System.currentTimeMillis());
        }

        ResponsePostVisitedLinks responsePostVisitedLinks = new ResponsePostVisitedLinks();
        responsePostVisitedLinks.status = "ok:" + System.currentTimeMillis();
        return responsePostVisitedLinks;
    }

    @GetMapping(path = "/visited_domains")
    public ResponseGetVisitedDomains getVisitedLinks(@RequestParam("from") long from, @RequestParam("to") long to){
        ResponseGetVisitedDomains get = new ResponseGetVisitedDomains();
        get.status = "ok";

        ArrayList<Visit> visits = dbService.get(from, to);
        for(Visit visit : visits){
            String url = visit.name;
            String[] protocolAndPath = url.split("://");
            String path = (protocolAndPath.length > 1) ? protocolAndPath[1] : protocolAndPath[0];
            String[] pathElement = path.split("/");
            String host = pathElement[0];
            get.domains.add(host);
        }

        return get;
    }
}
