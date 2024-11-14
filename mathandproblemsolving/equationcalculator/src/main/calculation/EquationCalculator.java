package mathandproblemsolving.equationcalculator.src.main.calculation;

import mathandproblemsolving.equationcalculator.src.main.output.Result;
import mathandproblemsolving.equationcalculator.src.main.utils.EquationFormulator;

import java.util.ArrayList;
import java.util.List;

public class EquationCalculator implements Calculator {

    private final EquationFormulator equationFormulator = new EquationFormulator();

    @Override
    public Result calculate(double[] values) {
        if (values.length == 0) {
            return new Result(0.0, "");
        }

        List<Double> equationComponents = new ArrayList<>();
        double result = divideAndConquer(values, 0, values.length - 1, equationComponents);
        String formattedEquation = equationFormulator.formatEquation(equationComponents);
        return new Result(result, formattedEquation);
    }

    private double divideAndConquer(double[] values, int left, int right, List<Double> components) {
        // Base case: single element
        if (left == right) {
            components.add(values[left]);
            return values[left];
        }

        int mid = (left + right) / 2;
        List<Double> leftComponents = new ArrayList<>();
        List<Double> rightComponents = new ArrayList<>();

        // Recursive calls to divide and conquer
        double leftResult = divideAndConquer(values, left, mid, leftComponents);
        double rightResult = divideAndConquer(values, mid + 1, right, rightComponents);

        // Merge with inclusion-exclusion
        double combinedResult = leftResult + rightResult - applyInclusionExclusion(leftComponents, rightComponents, components);

        // Add left and right components after merging
        components.addAll(leftComponents);
        components.addAll(rightComponents);
        return combinedResult;
    }

    private double applyInclusionExclusion(List<Double> left, List<Double> right, List<Double> combined) {
        double productSum = 0.0;

        // Calculate pairwise products with inclusion-exclusion
        for (Double l : left) {
            for (Double r : right) {
                double product = l * r;
                productSum += product;
                combined.add(-product); // Apply exclusion by adding negative product
            }
        }
        return productSum;
    }
}












