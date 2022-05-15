package trigFunctions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тригонометрическая функция sec(x) * tan(x)")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntireModuleTest {

    // Constants
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    // Functions
    private TrigonometricFunction function;
    private Tan tan;
    private Sec sec;

    @BeforeAll
    void init() {
        this.sec = new Sec(ACCURACY);
        this.tan = new Tan(ACCURACY);
        this.function = new TrigonometricFunction(ACCURACY, sec, tan);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("Тангенс и секанс - заглушки")
    void Stubbed(Double x, Double expectedResult) {
        double actualResult = function.retrieveStubbedValue(x, tan.getStubsTable().get(x), sec.getStubsTable().get(x));
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("Без заглушек")
    void noStubs(Double x, Double expectedResult) {
        double actualResult = function.calc(x);
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("Тангенс - заглушка")
    void StubbedTan(Double x, Double expectedResult) {
        double actualResult = function.retrieveStubbedValue(x, tan.getStubsTable().get(x), sec.calc(x));
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("Секанс - заглушка")
    void StubbedSec(Double x, Double expectedResult) {
        double actualResult = function.retrieveStubbedValue(x, tan.calc(x), sec.getStubsTable().get(x));
        assertEquals(expectedResult, actualResult, DELTA);
    }

}
