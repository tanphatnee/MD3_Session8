package Th2.ra;

public class Vehicle {
    private String brand;
    private String color;
    public Vehicle(){

    }
    public Vehicle(String brand, String color){
        this.brand = brand;
        this.color = color;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    @Override
    public String toString(){
        return "Vehicle{" +
                "brand" + brand + "\'" +
                ", color='" + color + "\'"+
                "}";
    }
}
