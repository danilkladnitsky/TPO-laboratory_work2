package trigFunctions;

import function.AbstractFunction;

import static java.lang.Math.*;

public class Cos extends AbstractFunction {

    private final Sin sinCalculator;

    public Cos(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new Sin(accuracy);
    }

    public Double calc(Double arg) {
        return sinCalculator.calc(arg + PI / 2);
    }
}
