package logFunctions;

import function.AbstractFunction;
import static java.lang.Double.*;

public class Log5 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.5, -0.431);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.4, 0.209);
        getStubsTable().put(2.3, 0.518);
        getStubsTable().put(3.4, 0.76);
        getStubsTable().put(5.2, 1.024);
        getStubsTable().put(10.515, 1.462);
        getStubsTable().put(11.5234, 1.519);
        getStubsTable().put(14.8432, 1.676);
        getStubsTable().put(100.0, 2.861);

        // Integration mockups
        getStubsTable().put(25.0, 2.0);
        getStubsTable().put(40.0, 2.292029674);
        getStubsTable().put(2.0, 0.4306765);
        getStubsTable().put(7.0, 1.20906195);
        getStubsTable().put(27.0, 2.047815);
    }

    private final Ln ln;

    public Log5(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calc(Double x) {
        return ln.calc(x) / ln.calc(5.0);
    }

    @Override
    public Double getStubValue(Double stub) {
        return stub / ln.getStubsTable().get(5.0);
    }
}
