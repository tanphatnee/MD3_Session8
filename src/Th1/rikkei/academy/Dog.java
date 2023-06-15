package Th1.rikkei.academy;

public class Dog extends Animal{
    private String color;
    public Dog(){

    }
    public Dog(String name, String color){
        super(name);
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public String setColor() {
        this.color = color;
    }

    @Override
    public String makeSound(){
        return "Gâu gâu";
    }
}
