package com.morse_code_generator.controller;

import com.morse_code_generator.model.MorseRequest;
import com.morse_code_generator.model.MorseResponse;
import com.morse_code_generator.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/morse")
@CrossOrigin(origins = "http://localhost:5173/")
public class MorseController {

    @Autowired
    private MorseService morseservice;

    @GetMapping("/test")
    public String test(){
        return "WORKING";
    }


    @PostMapping("/encode")
    public MorseResponse encode(@RequestBody MorseRequest request){
        return morseservice.encode(request);
    }

    @PostMapping("/decode")
    public MorseResponse decode(@RequestBody MorseRequest request){
        return morseservice.decode(request);
    }



}
