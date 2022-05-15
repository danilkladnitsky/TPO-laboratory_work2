package trigFunctions;

import function.AbstractFunction;

public class TrigonometricFunction extends AbstractFunction {
    private final Tan tan;
    private final Sec sec;

    public TrigonometricFunction(Double accuracy, Sec sec, Tan tan) {
        super(accuracy);
        this.tan = tan;
        this.sec = sec;
    }

    public Double calculateFunction(Double x) {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return tan.calculateFunction(x) * sec.calculateFunction(x);
    }

    public Double getStubValue(Double x, Double sec, Double tan) {
        if (x > 0.0) {
            throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        }

        return sec * tan;
    }
}