package logFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Логарифмические функции")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntireModuleTest {

    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;
    private LogarithmicFunction function;

    private final double DELTA = 0.05;
    private final double ACCURACY = 0.0001;

    @BeforeAll
    void init() {
        this.ln = new Ln(ACCURACY);
        this.log2 = new Log2(ACCURACY, ln);
        this.log3 = new Log3(ACCURACY, ln);
        this.log5 = new Log5(ACCURACY, ln);
        this.log10 = new Log10(ACCURACY, ln);
        this.function = new LogarithmicFunction(ACCURACY, ln, log2, log3, log5, log10);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubbed(Double x, Double expectedResult) {
        double lnStubbedValue = ln.getStubsTable().get(x);
        double log2StubbedValue = log2.getStubsTable().get(x);
        double log3StubbedValue = log3.getStubsTable().get(x);
        double log5StubbedValue = log5.getStubsTable().get(x);
        double log10StubbedValue = log10.getStubsTable().get(x);

        double actualResult = function.getStubValue(x,
                lnStubbedValue,
                log2StubbedValue,
                log3StubbedValue, log5StubbedValue, log10StubbedValue);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubNaturalLog(Double x, Double expectedResult) {
        double lnValue = ln.calc(x);
        double log2StubbedValue = log2.getStubsTable().get(x);
        double log3StubbedValue = log3.getStubsTable().get(x);
        double log5StubbedValue = log5.getStubsTable().get(x);
        double log10StubbedValue = log10.getStubsTable().get(x);

        double actualResult = function.getStubValue(x,
                lnValue,
                log2StubbedValue,
                log3StubbedValue, log5StubbedValue, log10StubbedValue);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubLogBase2(Double x, Double expectedResult) {
        double lnStubbedValue = ln.getStubsTable().get(x);
        double log2Value = log2.calc(x);
        double log3StubbedValue = log3.getStubsTable().get(x);
        double log5StubbedValue = log5.getStubsTable().get(x);
        double log10StubbedValue = log10.getStubsTable().get(x);

        double actualResult = function.getStubValue(x, lnStubbedValue, log2Value,
                log3StubbedValue, log5StubbedValue, log10StubbedValue);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubLogBase3(Double x, Double expectedResult) {
        double lnStubbedValue = ln.getStubsTable().get(x);
        double log2StubbedValue = log2.getStubsTable().get(x);
        double log3Value = log3.calc(x);
        double log5StubbedValue = log5.getStubsTable().get(x);
        double log10StubbedValue = log10.getStubsTable().get(x);

        double actualResult = function.getStubValue(x, lnStubbedValue,
                log2StubbedValue,
                log3Value, log5StubbedValue, log10StubbedValue);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubLogBase5(Double x, Double expectedResult) {
        double lnStubbedValue = ln.getStubsTable().get(x);
        double log2StubbedValue = log2.getStubsTable().get(x);
        double log3StubbedValue = log3.getStubsTable().get(x);
        double log5Value = log5.calc(x);
        double log10StubbedValue = log10.getStubsTable().get(x);

        double actualResult = function.getStubValue(x, lnStubbedValue,
                log2StubbedValue,
                log3StubbedValue, log5Value, log10StubbedValue);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void stubLogBase10(Double x, Double expectedResult) {
        double lnStubbedValue = ln.getStubsTable().get(x);
        double log2StubbedValue = log2.getStubsTable().get(x);
        double log3StubbedValue = log3.getStubsTable().get(x);
        double log5StubbedValue = log5.getStubsTable().get(x);
        double log10Value = log10.calc(x);

        double actualResult = function.getStubValue(x, lnStubbedValue,
                log2StubbedValue,
                log3StubbedValue, log5StubbedValue, log10Value);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln.csv")
    void noStubs(Double x, Double expectedResult) {
        assertEquals(expectedResult, function.calc(x), DELTA);
    }

}
