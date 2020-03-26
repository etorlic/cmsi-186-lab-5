public class ConstantVelocityPod extends Pod {
    public ConstantVelocityPod(String name, double velocity) {
        super(name, t -> velocity);
    }
}