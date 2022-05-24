package com.axinalis.learningKuber.rest;

import com.axinalis.learningKuber.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private ObjectMapper mapper;
    private MainService service;

    public MainController(@Autowired ObjectMapper mapper, @Autowired MainService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("/compute")
    public String getPrimes(@RequestParam Long value){
        StringBuilder builder = new StringBuilder();
        builder.append("initial value : ").append(value).append("\n");
        builder.append("primes : ").append(service.getPrimesAsString(value));

        return builder.toString();
    }

    @GetMapping("/history")
    public String getHistory(){
        StringBuilder builder = new StringBuilder();
        builder.append("All requested values : ").append(service.getHistoryAsString());

        return builder.toString();
    }
}
