public class AnimalDogOverride {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}