package Cherepovskiy.Andrey.Calculator.Servises.Parser;

import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;

public class NameParser {
    public int parse(MathExpressionReader reader) {
        int lengthOfName = 0;
        int readPosition = reader.getReadPosition();
        String expression = reader.getExpression();
        if(isLetter(expression.charAt(readPosition))){
            ++lengthOfName;
        }
        while(isLetter(expression.charAt(readPosition + lengthOfName))
                || isNumber(expression.charAt(readPosition + lengthOfName))){
            ++lengthOfName;
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