package com.morsecode.MorseCodeGenerator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MorseLogics {
    private Map<String , String> morseCodeMap;

    public MorseLogics(){
        File morseFile = new File("src/main/resources/data/data.json");
        ObjectMapper objmap = new ObjectMapper();
        try{
            morseCodeMap = objmap.readValue(morseFile , Map.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Morse data loaded into Map");
    }

    public String textToMorse(String text){
        return " "+morseCodeMap.getOrDefault(text,"@");
    }

    public String morseToText(String text){
        for(Map.Entry<String,String> entry : morseCodeMap.entrySet()){
            if(entry.getValue().equals(text)) return entry.getKey();
        }
        return "@";
    }

}
