package logFunctions;

import function.AbstractFunction;

public class Log5 extends AbstractFunction {

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
    public Double retrieveStubbedValue(Double stub) {
        return stub / ln.getStubsTable().get(5.0);
    }

    {
        // Stub values
        getStubsTable().put(25.0, 2.0);
        getStubsTable().put(40.0, 2.292029674);
        getStubsTable().put(2.0, 0.4306765);
        getStubsTable().put(7.0, 1.20906195);
        getStubsTable().put(27.0, 2.047815);
    }
}
