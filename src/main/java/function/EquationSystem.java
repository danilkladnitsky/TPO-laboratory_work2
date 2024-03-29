package function;

import logFunctions.LogarithmicFunction;
import trigFunctions.TrigonometricFunction;

public class EquationSystem {
    private final TrigonometricFunction trigonometricFunction;
    private final LogarithmicFunction logarithmicFunction;

    public EquationSystem(TrigonometricFunction trigonometricFunction, LogarithmicFunction logarithmicFunction) {
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmicFunction = logarithmicFunction;
    }

    public Double calc(Double x) {
        if (x <= 0) {
            return trigonometricFunction.calc(x);
        }

        return logarithmicFunction.calc(x);
    }
}