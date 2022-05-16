package logFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Логарифмические функции")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InnerModulesTest {

    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.ln = new Ln(ACCURACY);
        this.log2 = new Log2(ACCURACY, ln);
        this.log3 = new Log3(ACCURACY, ln);
        this.log5 = new Log5(ACCURACY, ln);
        this.log10 = new Log10(ACCURACY, ln);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/ln_test.csv")
    void lnTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, ln.calc(x), DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/log2_test.csv")
    void log2Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log2.calc(x), DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/log3_test.csv")
    void log3Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log3.calc(x), DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/log5_test.csv")
    void log5Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log5.calc(x), DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/logarithmic/log10_test.csv")
    void log10Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log10.calc(x), DELTA);
    }

}
