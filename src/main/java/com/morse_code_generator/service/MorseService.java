package com.morse_code_generator.service;

import com.morse_code_generator.model.MorseRequest;
import com.morse_code_generator.model.MorseResponse;
import com.morse_code_generator.utils.MorseLogics;
import org.springframework.stereotype.Service;



@Service
public class MorseService {
    private MorseLogics morse = new MorseLogics();

    public MorseResponse encode(MorseRequest request){

        String userText = request.getText();
        StringBuilder respCode = new StringBuilder();

        for(char ch : userText.toCharArray()){
            respCode.append(morse.getMorseCode(String.valueOf(ch)));
        }

        MorseResponse response = new MorseResponse();
        response.setResult(respCode.toString().trim());
        response.setStatuscode(200);

        String de="-. .- ...-";
        System.out.println(de.contentEquals(respCode.toString().trim()));

        return response;
    }

    public MorseResponse decode(MorseRequest request){
        String[] inpCode = request.getText().split(" ");
        StringBuilder respText = new StringBuilder();
        for(String code : inpCode){
            respText.append(morse.decodeMorseCode(code));
        }

        MorseResponse response = new MorseResponse();
        response.setStatuscode(200);
        response.setResult(respText.toString());
        return response;
    }
}
