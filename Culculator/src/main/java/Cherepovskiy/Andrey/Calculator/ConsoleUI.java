package Cherepovskiy.Andrey.Calculator;

import Cherepovskiy.Andrey.Calculator.Servises.Calculator;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ConsoleUI {
    public void start() throws Exception{
        System.out.print("Enter expression");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expression = in.readLine();
        try{
            final BigDecimal result = new Calculator().evaluate(expression);
            System.out.println("result = " + result);
        }catch(EvaluationException e){
            System.out.println("Error message: " + e.getMessage());
            System.out.println("Position = "+e.getErrorPosition());
        }
    }
}