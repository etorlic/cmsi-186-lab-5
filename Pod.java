import java.util.function.Function;

public class Pod {
    private String name;
    private Function<Double, Double> velocityFunction;

    public Pod(String name, Function<Double, Double> velocityFunction) {
        this.name = name;
        this.velocityFunction = velocityFunction;
    }

    public String getName() {
        return name;
    }

    public double v(double t) {
        return velocityFunction.apply(t);
    }

    //takes the left Riemann sum
    public double distanceTraveled(double startTime, double endTime, int slices) {
        if (slices < 1) {
            throw new IllegalArgumentException("At least one slice required");
        }
        
        final double SUBINTERVAL = (endTime - startTime)/slices; 
        var vSum = 0.0;

        for (double i = startTime; i < endTime; i += SUBINTERVAL) {
            vSum += v(i);
        }

        return vSum * SUBINTERVAL;
    }
}