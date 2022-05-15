package trigFunctions;

import function.AbstractFunction;

import static java.lang.Math.*;

public class Sec extends AbstractFunction {
    private final Cos cosCalculator;

    {

        getStubsTable().put(-0.2, 1 / cos(-0.2));
        getStubsTable().put(-0.5, 1 / cos(-0.5));
        getStubsTable().put(-1.0, 1 / cos(-1.0));
        getStubsTable().put(-3.0, 1 / cos(-3.0));
        getStubsTable().put(-5.0, 1 / cos(-5.0));
    }

    public Sec(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new Cos(accuracy);
    }

    public Double calculateFunction(Double arg) {
        return 1 / cosCalculator.calculateFunction(arg);
    }
}
