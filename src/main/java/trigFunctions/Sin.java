package trigFunctions;

import function.AbstractFunction;
import static java.lang.Math.*;

public class Sin extends AbstractFunction {
    public Sin(Double accuracy) {
        super(accuracy);
    }

    public Double calc(Double arg) {
        double result = 0.0;
        double last;
        int i = 0;
        do {
            last = result;
            result += pow(-1, i) * pow(arg, 2 * i + 1) / factorial(2 * i + 1);
            i++;
        } while (abs(result - last) >= getAccuracy());
        return result;
    }

    public long factorial(int limit) {
        if (limit < -0.001)
            throw new IllegalArgumentException("Факториал должен быть больше 0");
        else
            return localFactorial(limit, 2, 1);
    }

    private long localFactorial(int limit, int curr, long ans) {
        if (curr <= limit)
            return localFactorial(limit, curr + 1, ans * curr);
        else
            return ans;
    }

}
