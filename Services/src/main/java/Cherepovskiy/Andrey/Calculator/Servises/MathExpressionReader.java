package Cherepovskiy.Andrey.Calculator.Servises;

public class MathExpressionReader {

    private final String expression;
    private int previousReadPosition = 0;
    private int readPosition = 0;

    public MathExpressionReader(String expression) {

        if (expression == null) {
            throw new NullPointerException("Null expression passed.");
        }

        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public int getReadPosition() {
        return readPosition;
    }

    public int getPreviousReadPosition(){
        return previousReadPosition;
    }

    public char getCurrentChar() {
        return expression.charAt(readPosition);
    }

    public void incReadPosition() {
        previousReadPosition = readPosition;
        readPosition++;
    }

    public void incReadPosition(int amount) {
        previousReadPosition = readPosition;
        readPosition += amount;
    }

    public void setReadPosition(int readPosition) {
        previousReadPosition = readPosition;
        this.readPosition = readPosition;
    }

    public boolean endOfExpression() {
        return readPosition + 1 > expression.length();
    }

    public void moveToNextNotSpacePosition(){
        if(endOfExpression()){
            return;
        }
        previousReadPosition = readPosition;
        while(expression.charAt(readPosition) == ' '){
            ++readPosition;
            if(endOfExpression()){
                break;
            }
        }
    }

}
