package com.morsecode.MorseCodeGenerator.service;


import com.morsecode.MorseCodeGenerator.model.MorseRequest;
import com.morsecode.MorseCodeGenerator.model.MorseResponse;
import com.morsecode.MorseCodeGenerator.utils.MorseLogics;
import org.springframework.stereotype.Service;

@Service
public class MorseService {

    private MorseLogics morseLogics = new MorseLogics();


    public MorseResponse encode(MorseRequest request){

        char[] textArr = request.getText().toCharArray();
        StringBuilder encodeText = new StringBuilder();

        for( char ch : textArr )
            encodeText.append(morseLogics.textToMorse(String.valueOf(ch)));


        MorseResponse response = new MorseResponse();

        response.setText(encodeText.toString().trim());
        response.setStatusCode(200);
        return response;
    }

    public MorseResponse decode(MorseRequest request){

        String[] reqTextArr = request.getText().split(" ");
        StringBuilder respText = new StringBuilder();

        for( String str : reqTextArr )
            respText.append(morseLogics.morseToText(str));


        MorseResponse response = new MorseResponse();
        response.setText(respText.toString().toLowerCase());
        response.setStatusCode(200);
        return response;
    }

}
