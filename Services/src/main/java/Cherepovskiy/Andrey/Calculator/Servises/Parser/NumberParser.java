package Cherepovskiy.Andrey.Calculator.Servises.Parser;


import Cherepovskiy.Andrey.Calculator.Servises.MathExpressionReader;
import Cherepovskiy.Andrey.Calculator.Servises.Command.NumberCommand;
import Cherepovskiy.Andrey.Calculator.Servises.Command.EvaluationCommand;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;

public class NumberParser implements MathExpressionParser {

    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("0.0");

    @Override
    public EvaluationCommand parse(MathExpressionReader reader) {
        DecimalFormatSymbols custom = new DecimalFormatSymbols();
        custom.setDecimalSeparator('.');
        NUMBER_FORMAT.setDecimalFormatSymbols(custom);

        reader.moveToNextNotSpacePosition();

        final ParsePosition position = new ParsePosition(reader.getReadPosition());

        final Number number = NUMBER_FORMAT.parse(reader.getExpression(), position);

        if (position.getErrorIndex() < 0) {

            final int readPosition = position.getIndex();
            reader.setReadPosition(readPosition);

            return new NumberCommand(new BigDecimal(number.doubleValue()));
        }

        return null;
    }
}
