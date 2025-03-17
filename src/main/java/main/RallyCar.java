package main;

abstract class RallyCar {
    String make;
    String model;
    int horsePower;

    /** constructor for rally car.
     * 
     * @param make
     * @param model
     * @param horsePower
     */
    public RallyCar(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }
    
    /**
     * these are all getters for the rally car.
     * @return
     */
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    /**
     * returns performance rating as a double
     * @return
     */
    public abstract double calculatePerformance();

}