package function;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractFunction {
    private Map<Double, Double> stubsTable = new HashMap<>();
    private Double accuracy;

    public AbstractFunction(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getStubValue(Double stub) {
        return calc(stub);
    }

    public abstract Double calc(Double x);
}