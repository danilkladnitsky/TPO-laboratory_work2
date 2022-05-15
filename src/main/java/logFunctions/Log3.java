package logFunctions;

import function.AbstractFunction;

public class Log3 extends AbstractFunction {
    private final Ln ln;

    {
        // Stub values
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
    public Double calc(Double x) {
        return ln.calc(x) / ln.calc(3.0);
    }

    @Override
    public Double retrieveStubbedValue(Double stub) {
        return stub / ln.getStubsTable().get(3.0);
    }
}
