package logFunctions;

import function.AbstractFunction;

public class Log10 extends AbstractFunction {

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

    {
        // Stub values
        getStubsTable().put(25.0, 1.39794);
        getStubsTable().put(40.0, 1.602059991);
        getStubsTable().put(2.0, 0.30102999566);
        getStubsTable().put(7.0, 0.845098);
        getStubsTable().put(27.0, 1.431363);
    }
}
