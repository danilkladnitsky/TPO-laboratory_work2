package logFunctions;

import function.AbstractFunction;
import static java.lang.Double.*;

public class Log3 extends AbstractFunction {

    private final Ln ln;

    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);

        getStubsTable().put(9.0, 2.0);
        getStubsTable().put(81.0, 4.0);
        getStubsTable().put(243.0, 5.0);
        getStubsTable().put(729.0, 6.0);

        getStubsTable().put(25.0, 2.92994);
        getStubsTable().put(40.0, 3.35776278);
        getStubsTable().put(2.0, 0.63092975);
        getStubsTable().put(7.0, 1.77124374);
        getStubsTable().put(27.0, 3.0);
    }

    public Log3(Double accuracy, Ln ln) {
        super(accuracy);
        this.ln = new Ln(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(3.0);
    }

    @Override
    public Double getStubValue(Double stub) {
        return stub / ln.getStubsTable().get(3.0);
    }
}
