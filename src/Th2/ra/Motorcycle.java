package Th2.ra;

public class Motorcycle extends Vehicle {
    public Motorcycle() {

    }
    public Motorcycle(String brand, String color) {
        super(brand, color);
    }
    @Override
    public String toString() {
        return "Motorcycle{" +
                "brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor() + '\'' +
                '}';
    }
}
