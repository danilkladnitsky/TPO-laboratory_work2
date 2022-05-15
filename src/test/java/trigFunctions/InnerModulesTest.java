package trigFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import trigFunctions.Sec;
import trigFunctions.Tan;

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
    @CsvSource(value = {
            "-3.1415926, -1.0",
            "0.0, 1.0",
            "1, 1.85081",
            "2, -2.40299",
            "3.1415926, -1.0"
    })
    void secTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sec.calculateFunction(x), DELTA);
    }

    // Tangence Testing

    @Test
    void criticalPointsForTanTest() {
        final double MAX_ACCURACY = 0.000000001;
        final double NAN_VALUE = Double.NaN;
        final double NEGATIVE_VALUE = Double.NEGATIVE_INFINITY;

        Tan tan = new Tan(MAX_ACCURACY);

        assertEquals(NEGATIVE_VALUE, tan.calculateFunction(-PI / 2.0));
        assertEquals(NAN_VALUE, tan.calculateFunction(PI / 2.0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-3.1415926,  0.0",
            "-1.5,    -14.1014224",
            "-2,   2.18503",
            "-3, 0.14254",
            "0.0,      0.0",
            "1,     1.55740",
            "2,      -2.18503",
            "3.1415926,   0.0"
    })
    void tanTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, tan.calculateFunction(x), DELTA);
    }

}
