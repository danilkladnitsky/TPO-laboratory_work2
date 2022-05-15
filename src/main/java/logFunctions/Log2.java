package logFunctions;

import function.AbstractFunction;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.log;

public class Log2 extends AbstractFunction {

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.5, -1.0);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.4, 0.485);
        getStubsTable().put(2.3, 1.202);
        getStubsTable().put(3.4, 1.766);
        getStubsTable().put(5.2, 2.379);
        getStubsTable().put(10.515, 3.394);
        getStubsTable().put(11.5234, 3.526);
        getStubsTable().put(14.8432, 3.892);
        getStubsTable().put(100.0, 6.644);

        // Integration mockups
        getStubsTable().put(25.0, 4.64385);
        getStubsTable().put(40.0, 5.321028094);
        getStubsTable().put(2.0, 1.0);
        getStubsTable().put(7.0, 2.807354922);
        getStubsTable().put(27.0, 4.7548875);
    }

    private final Ln ln;

    public Log2(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(2.0);
    }

    @Override
    public Double getStubValue(Double stub) {
        return stub / ln.getStubsTable().get(2.0);
    }
}
