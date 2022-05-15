package logFunctions;

import function.AbstractFunction;

public class LogarithmicFunction extends AbstractFunction {

    private final Ln ln;
    private final Log2 log2;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogarithmicFunction(Double accuracy, Ln ln, Log2 log2, Log3 log3, Log5 log5, Log10 log10) {
        super(accuracy);
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public Double calc(Double x) {
        if (x <= 0.0) {
            throw new IllegalArgumentException("(!) x > 0");
        }

        double lnX = ln.calc(x);
        double log2X = log2.calc(x);
        double log3X = log3.calc(x);
        double log5X = log5.calc(x);
        double log10X = log10.calc(x);

        return calculateOutput(lnX, log2X, log3X, log5X, log10X);
    }

    public Double retrieveStubbedValue(Double x, Double ln, Double log2, Double log3, Double log5, Double log10) {
        if (x <= 0.0) {
            throw new IllegalArgumentException("(!) x > 0");
        }

        return calculateOutput(ln, log2, log3, log5, log10);
    }

    public Double calculateOutput(Double ln, Double log2, Double log3, Double log5, Double log10) {
        double firstMember = (Math.pow((log5 + ln), 3) + ln) / ((log2 / ln) * log5);
        double secondMember = Math.pow((log2 / log10), 3) + ln;
        double thirdMember = (log2 - log10);
        double fourthmember = log3;

        return firstMember + (secondMember + thirdMember + fourthmember);

    }
}