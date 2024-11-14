package mathandproblemsolving.equationcalculator.src.test;

import mathandproblemsolving.equationcalculator.src.main.calculation.EquationCalculator;
import mathandproblemsolving.equationcalculator.src.main.calculation.Calculator;
import mathandproblemsolving.equationcalculator.src.main.output.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquationCalculatorTest {

    private final Calculator calculator = new EquationCalculator();

    @Test
    public void testCalculateSimpleInput() {
        double[] values = {2.0, 4.0, 6.0};
        Result result = calculator.calculate(values);
        assertEquals(16.0, result.getValue(), 0.001);
    }

    @Test
    public void testCalculateWithFourElements() {
        double[] values = {2.0, 4.0, 6.0, 8.0};
        Result result = calculator.calculate(values);
        assertEquals(-104.0, result.getValue(), 0.001);
    }

    @Test
    public void testCalculateSingleElement() {
        double[] values = {5.0};
        Result result = calculator.calculate(values);
        assertEquals(5.0, result.getValue(), 0.001);
    }

    @Test
    public void testCalculateWithNoElements() {
        double[] values = {};
        Result result = calculator.calculate(values);
        assertEquals(0.0, result.getValue(), 0.001);
        assertEquals("", result.getEquation());
    }
}





