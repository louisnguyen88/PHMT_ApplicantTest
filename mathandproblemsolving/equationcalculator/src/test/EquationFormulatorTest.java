package mathandproblemsolving.equationcalculator.src.test;

import mathandproblemsolving.equationcalculator.src.main.utils.EquationFormulator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquationFormulatorTest {

    private final EquationFormulator equationFormulator = new EquationFormulator();

    @Test
    public void testFormattedEquationOutput() {
        List<Double> components = Arrays.asList(2.0, 4.0, 6.0, -8.0, -12.0, -24.0, 48.0);
        String formattedEquation = equationFormulator.formatEquation(components);
        String expectedEquation = "(2.0) + (4.0) + (6.0) - (8.0) - (12.0) - (24.0) + (48.0)";
        assertEquals(expectedEquation, formattedEquation.trim());
    }

    @Test
    public void testFormattedEquationOutputWithFourElements() {
        List<Double> components = Arrays.asList(2.0, 4.0, 6.0, 8.0, -8.0, -12.0, -16.0, -24.0, -32.0, -48.0, 96.0, 128.0, 192.0, 384.0, -768.0);
        String formattedEquation = equationFormulator.formatEquation(components);
        String expectedEquation = "(2.0) + (4.0) + (6.0) + (8.0) - (8.0) - (12.0) - (16.0) - (24.0) - (32.0) - (48.0) + (96.0) + (128.0) + (192.0) + (384.0) - (768.0)";
        assertEquals(expectedEquation, formattedEquation.trim());
    }
}
