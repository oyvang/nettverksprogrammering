package oving2.oppgave1;

import java.text.ParseException;
import java.util.*;

/**
 * Created by GeirMorten on 23.02.14.
 */
public class Calculator {
    private String[] inputSplited;

    public Calculator (){
    }

    private String[] inputSplitter(String input){
        return inputSplited = input.split(" ");
    }

    private boolean isOperatorAdder(String operator){
        return operator.equals("+");
    }

    public Integer Calculate(String input) throws ParseException {
        if(!input.matches("^-?\\d+\\s[+|-]\\s-?\\d+")){
           throw new ParseException("Feil syntax! eks: -1 + -5",25);
        }
        inputSplited = inputSplitter(input);
        try{
            int a = Integer.parseInt(inputSplited[0]);
            int b = Integer.parseInt(inputSplited[2]);
            return isOperatorAdder(inputSplited[1]) ? a+b : a-b;
        }catch (NumberFormatException e){
            throw new ParseException("Kan ikke omforme tallene!", 29);
        }
    }


}
