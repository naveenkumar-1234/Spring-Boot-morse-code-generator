package com.morse_code_generator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MorseLogics {
    private Map<String, String> morsecodeMap;

     public MorseLogics(){
        File fl = new File("src/data/data.json");
        ObjectMapper objmap = new ObjectMapper();
        try{
            morsecodeMap = objmap.readValue( fl, Map.class );
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("MorseCode added into HashMap");
    }

    public String getMorseCode(String inp){
         return " " + morsecodeMap.getOrDefault(inp   ,"@");
    }

    public String decodeMorseCode(String inp){
        for(Map.Entry<String,String> entry : morsecodeMap.entrySet()){
            if(entry.getValue().equals(inp.toUpperCase())) return entry.getKey();
        }
        return "@";
    }


}
