package mathandproblemsolving.equationcalculator.src.main.output;

public class Result {
    private final double value;
    private final String equation;

    public Result(double value, String equation) {
        this.value = value;
        this.equation = equation;
    }

    public double getValue() {
        return value;
    }

    public String getEquation() {
        return equation;
    }
}

