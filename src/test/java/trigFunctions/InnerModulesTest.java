package trigFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тригонометрические функции sec и tan")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InnerModulesTest {

    private Tan tan;
    private Sec sec;

    private final double ACCURACY = 0.0001;
    private final double DELTA = 0.0005;

    @BeforeAll
    void init() {
        this.tan = new Tan(ACCURACY);
        this.sec = new Sec(ACCURACY);
    }

    // Secance Testing
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/sec_test.csv")
    void secTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sec.calc(x), DELTA);
    }

    // Tangence Testing
    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/tan_test.csv")
    void tanTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, tan.calc(x), DELTA);
    }

    // Critical points
    @Test
    void criticalPointsForTanTest() {
        final double MAX_ACCURACY = 0.000000001;
        final double NAN_VALUE = Double.NaN;
        final double NEGATIVE_VALUE = Double.NEGATIVE_INFINITY;

        Tan tan = new Tan(MAX_ACCURACY);

        assertEquals(NEGATIVE_VALUE, tan.calc(-PI / 2.0));

        assertEquals(NAN_VALUE, tan.calc(PI / 2.0));
        assertEquals(NAN_VALUE, tan.calc(2 * PI / 2.0));
        assertEquals(NAN_VALUE, tan.calc(4 * PI / 2.0));
        assertEquals(NAN_VALUE, tan.calc(6 * PI / 2.0));
        assertEquals(NAN_VALUE, tan.calc(8 * PI / 2.0));
        assertEquals(NAN_VALUE, tan.calc(10 * PI / 2.0));
    }

    @Test
    void criticalPointsForSecTest() {
        final double MAX_ACCURACY = 0.000000001;
        final double NAN_VALUE = Double.NaN;
        final double POSITIVE_VALUE = Double.POSITIVE_INFINITY;

        Sec sec = new Sec(MAX_ACCURACY);

        assertEquals(POSITIVE_VALUE, sec.calc(-PI / 2.0));

        assertEquals(NAN_VALUE, sec.calc(2 * PI / 2.0));
        assertEquals(NAN_VALUE, sec.calc(4 * PI / 2.0));
        assertEquals(NAN_VALUE, sec.calc(6 * PI / 2.0));
        assertEquals(NAN_VALUE, sec.calc(8 * PI / 2.0));
        assertEquals(NAN_VALUE, sec.calc(10 * PI / 2.0));
    }

}
