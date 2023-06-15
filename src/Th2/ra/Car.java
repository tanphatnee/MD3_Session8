package Th2.ra;

public class Car extends  Vehicle{
    public Car(){

    }
    public Car(String brand, String color) {
        super(brand, color);
    }
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + this.getBrand() + '\'' +
                ", color='" + this.getColor()+ '\'' +
                '}';
    }

    public void setColor(String yelow) {
    }
}
