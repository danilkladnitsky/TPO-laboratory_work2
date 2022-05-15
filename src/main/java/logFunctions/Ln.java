package logFunctions;

import function.AbstractFunction;

import static java.lang.Double.*;

public class Ln extends AbstractFunction {
    {
        // Stub values
        getStubsTable().put(25.0, 3.21887);
        getStubsTable().put(40.0, 3.6888794);
        getStubsTable().put(2.0, 0.69314718);
        getStubsTable().put(7.0, 1.94591015);
        getStubsTable().put(27.0, 3.295836866);
    }

    public Ln(Double accuracy) {
        super(accuracy);
    }

    @Override
    public Double calc(Double x) {
        if (isNaN(x) || x < 0.0)
            return NaN;

        if (x == POSITIVE_INFINITY)
            return POSITIVE_INFINITY;

        if (x == 0.0)
            return NEGATIVE_INFINITY;

        double value = 0;

        int n = 1;
        int k = 1;

        double accuracy = getAccuracy();
        double prevValue;

        if (Math.abs(x - 1) <= 1) {
            do {
                prevValue = value;

                value = value - ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);

                n++;
            } while (accuracy <= Math.abs(value - prevValue));
        } else {
            do {
                prevValue = value;

                value = value - ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);

                k++;
            } while (accuracy <= Math.abs(value - prevValue));
            value += this.calc(x - 1);
        }
        return value;
    }
}