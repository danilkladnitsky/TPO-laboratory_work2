package logFunctions;

import function.AbstractFunction;

public class Log2 extends AbstractFunction {
    {
        // Stub values
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
    public Double calc(Double x) {
        return ln.calc(x) / ln.calc(2.0);
    }

    @Override
    public Double retrieveStubbedValue(Double stub) {
        return stub / ln.getStubsTable().get(2.0);
    }
}
