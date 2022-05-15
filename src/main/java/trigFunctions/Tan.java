package trigFunctions;

import function.AbstractFunction;
import static java.lang.Math.*;

public class Tan extends AbstractFunction {
    {
        getStubsTable().put(-0.2, sin(-0.2) / cos(-0.2));
        getStubsTable().put(-0.5, sin(-0.5) / cos(-0.5));
        getStubsTable().put(-1.0, sin(-1.0) / cos(-1.0));
        getStubsTable().put(-3.0, sin(-3.0) / cos(-3.0));
        getStubsTable().put(-5.0, sin(-5.0) / cos(-5.0));
    }

    private final Sin sinCalculator;
    private final Cos cosCalculator;

    public Tan(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new Sin(accuracy);
        this.cosCalculator = new Cos(accuracy);
    }

    public Double calc(Double arg) {
        return sinCalculator.calc(arg) / cosCalculator.calc(arg);
    }

}
