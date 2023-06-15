package Th2.ra;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("TO", "Bl");
        Car car2 = new Car("FO", "WH");
        System.out.println("Xe 1 " + car1.getBrand());
        car1.setColor("yelow");
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        Motorcycle motor1 = new Motorcycle("Hd", "bl");
        Motorcycle motor2 = new Motorcycle("Ya", "ye");
        System.out.println(motor1.toString());
        System.out.println(motor2.toString());
    }
}
