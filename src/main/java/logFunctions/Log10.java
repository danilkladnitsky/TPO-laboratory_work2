package logFunctions;

import function.AbstractFunction;
import static java.lang.Double.*;

public class Log10 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.5, -0.301);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.4, 0.146);
        getStubsTable().put(2.3, 0.362);
        getStubsTable().put(3.4, 0.531);
        getStubsTable().put(5.2, 0.716);
        getStubsTable().put(10.515, 1.022);
        getStubsTable().put(11.5234, 1.062);
        getStubsTable().put(14.8432, 1.172);
        getStubsTable().put(100.0, 2.0);

        // Integration mockups
        getStubsTable().put(25.0, 1.39794);
        getStubsTable().put(40.0, 1.602059991);
        getStubsTable().put(2.0, 0.30102999566);
        getStubsTable().put(7.0, 0.845098);
        getStubsTable().put(27.0, 1.431363);
    }

    private final Ln ln;

    public Log10(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calc(Double x) {
        return ln.calc(x) / ln.calc(10.0);
    }

    @Override
    public Double retrieveStubbedValue(Double stub) {
        return stub / ln.getStubsTable().get(10.0);
    }
}
