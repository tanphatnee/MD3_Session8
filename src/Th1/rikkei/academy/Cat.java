package Th1.rikkei.academy;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
    @Override
    public String makeSound() {
        return "Mew Mew";
    }
}
