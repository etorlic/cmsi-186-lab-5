import java.util.function.Function;

public class PolynomialPod extends Pod {
    public PolynomialPod(String name, double... c) {
        super(name, t -> polyFunction(c));
    }

    public static Function<Double, Double> polyFunction(double... c) {
        Function<Double, Double>  polyFunction;
        for (int i = 0; i < c.length; i++) {
            polyFunction += c * Math.pow(t, i);
        }
        return polyFunction;
    }
}