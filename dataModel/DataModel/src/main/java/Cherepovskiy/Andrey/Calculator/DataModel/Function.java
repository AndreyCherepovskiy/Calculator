package Cherepovskiy.Andrey.Calculator.DataModel;

import java.math.BigDecimal;

public interface Function {
    BigDecimal evaluate(BigDecimal... arguments);

    int getMinimumNumberArguments();

    int getMaximumNumberArguments();
}