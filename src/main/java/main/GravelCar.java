package main;

public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, int horsePower) {
        super(make, model, horsePower);
    }

    @Override
    public double calculatePerformance() {
        return getHorsePower() * 0.85;
    }

}