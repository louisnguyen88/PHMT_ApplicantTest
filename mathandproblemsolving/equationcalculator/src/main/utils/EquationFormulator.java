package mathandproblemsolving.equationcalculator.src.main.utils;

import java.util.List;

public class EquationFormulator {

    public String formatEquation(List<Double> components) {
        StringBuilder equation = new StringBuilder();

        for (int i = 0; i < components.size(); i++) {
            double component = components.get(i);

            if (i > 0) {
                equation.append(component >= 0 ? " + " : " - ");
            } else if (component < 0) {
                equation.append("-");
            }

            equation.append("(").append(Math.abs(component)).append(")");
        }

        return equation.toString().trim();
    }
}

