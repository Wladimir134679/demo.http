package com.example.http.demo.data;

import java.util.ArrayList;

public class ResponseGetVisitedDomains extends ResponseBody {

    public ArrayList<String> domains;

    public ResponseGetVisitedDomains() {
        domains = new ArrayList<>();
    }
}
