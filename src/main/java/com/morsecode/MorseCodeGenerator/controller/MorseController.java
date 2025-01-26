package com.morsecode.MorseCodeGenerator.controller;


import com.morsecode.MorseCodeGenerator.model.MorseRequest;
import com.morsecode.MorseCodeGenerator.model.MorseResponse;
import com.morsecode.MorseCodeGenerator.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/v1/morse")
public class MorseController {

    @Autowired
    public MorseService morseService;

    @GetMapping("/test")
    public String test(){
        return "Perfectly working";
    }

    @PostMapping("/encode")
    public MorseResponse encode(@RequestBody MorseRequest request){
        return morseService.encode(request);
    }

    @PostMapping("/decode")
    public MorseResponse decode(@RequestBody MorseRequest request){
        return morseService.decode(request);
    }
}
