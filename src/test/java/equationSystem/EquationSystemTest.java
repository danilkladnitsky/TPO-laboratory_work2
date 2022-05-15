package equationSystem;

import function.AbstractFunction;
import function.EquationSystem;
import logFunctions.*;
import trigFunctions.*;
import utils.CsvLogger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Интеграционный тест")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EquationSystemTest {
        private EquationSystem systemSolver;
        private AbstractFunction systemSolverLog;

        private final Double DELTA = 0.05;
        private final Double ACCURACY = 0.001;

        @ParameterizedTest
        @CsvFileSource(resources = "/system.csv")
        void entireSystemTest(Double x, Double expectedResult) {
                Ln ln = new Ln(ACCURACY);

                TrigonometricFunction firstFunction = new TrigonometricFunction(ACCURACY,
                                new Sec(ACCURACY),
                                new Tan(ACCURACY));

                LogarithmicFunction secondFunction = new LogarithmicFunction(ACCURACY, new Ln(
                                ACCURACY),
                                new Log2(ACCURACY, ln),
                                new Log3(ACCURACY, ln),
                                new Log5(ACCURACY, ln),
                                new Log10(ACCURACY, ln));

                this.systemSolver = new EquationSystem(
                                firstFunction,
                                secondFunction);

                assertEquals(expectedResult, systemSolver.calc(x), DELTA);
        }

}