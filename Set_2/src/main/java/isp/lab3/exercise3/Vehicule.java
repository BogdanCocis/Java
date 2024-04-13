package isp.lab3.exercise3;

import java.util.Objects;

public class Vehicule {
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    private static int numberOfVehicles = 0;

    public Vehicule(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        numberOfVehicles++;
    }

    public static int displayNumberOfVehicles() {
return numberOfVehicles;
    }

    @Override
    public String toString() {
        return "{" + model + " (" + type + ") viteza " + speed + " km/h}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return speed == vehicule.speed && fuelType == vehicule.fuelType && Objects.equals(model, vehicule.model) && Objects.equals(type, vehicule.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type, speed, fuelType);
    }
}
