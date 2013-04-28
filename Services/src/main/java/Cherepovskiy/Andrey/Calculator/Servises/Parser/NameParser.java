package Cherepovskiy.Andrey.Calculator.Servises.Parser;

import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;

import java.math.BigDecimal;

public class NameParser {

    public int parse(MathExpressionReader reader) {
        int lengthOfName = 0;
        int readPosition = reader.getReadPosition();
        String expression = reader.getExpression();
        if(isLetter(expression.charAt(readPosition))){
            ++lengthOfName;
        }
        while(isLetter(expression.charAt(readPosition + lengthOfName)) || isNumber(expression.charAt(readPosition + lengthOfName))){
            ++lengthOfName;
            if(readPosition + lengthOfName >= expression.length()) {
                return --lengthOfName;
            }
        }
        return lengthOfName;
    }

    private boolean isLetter(char argument){
        return (argument >= 'a' && argument <= 'z') || (argument >= 'A' && argument <= 'Z');
    }

    private boolean isNumber(char argument){
        return argument >= '0' && argument <= '9';
    }
}