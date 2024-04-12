/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abren Trangia
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

abstract class Animal {
    String name;
    int age;
    double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    abstract void makeSound();
    abstract void eat();
    abstract void sleep();
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Mammal extends Animal {
    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println("Mammal makes AAAAAAAAAA");
    }

    @Override
    void eat() {
        System.out.println("Mammal chomp chommp");
    }

    @Override
    void sleep() {
        System.out.println("Mammal zzzzzzz");
    }
}

class Bird extends Animal implements Flyable {
    double wingspan;

    public Bird(String name, int age, double weight, double wingspan) {
        super(name, age, weight);
        this.wingspan = wingspan;
    }

    @Override
    void makeSound() {
        System.out.println("The Bird makes tweet tweet");
    }

    @Override
    void eat() {
        System.out.println("The Bird is nom nom");
    }

    @Override
    void sleep() {
        System.out.println("The Bird is zzzzzz");
    }

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println("The Fish makes a blop blop");
    }

    @Override
    void eat() {
        System.out.println("The Fish is nom nom");
    }

    @Override
    void sleep() {
        System.out.println("The Fish is zzzzzz");
    }

    @Override
    public void swim() {
        System.out.println("Fish walking under water");
    }
}

class Primate extends Mammal {
    public Primate(String name, int age, double weight) {
        super(name, age, weight);
    }
}

class Ape extends Primate implements Swimmable {
    public Ape(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void swim() {
        System.out.println("Ape swimming");
    }
}

class Monkey extends Primate implements Swimmable, Flyable {
    public Monkey(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void swim() {
        System.out.println("Monkey swimming");
    }

    @Override
    public void fly() {
        System.out.println("Monkey flying");
    }
}

interface Climber {
    void climb();
}

class ClimbingMonkey extends Monkey implements Climber {
    public ClimbingMonkey(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void climb() {
        System.out.println("Monkey climbing");
    }
}



public class AnimalZooo {
private List<Animal> animals = new ArrayList<>();

    
    public static void main(String[] args) {
             AnimalZooo zooManager = new AnimalZooo();
        zooManager.startZooManager();
    }

    
    
     public void simulateZoo() {
        for (Animal animal : animals) {
            System.out.println(animal.name + " is doing the following:");
            animal.makeSound();
            animal.eat();
            animal.sleep();
            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }
            if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
            if (animal instanceof Climber) {
                ((Climber) animal).climb();
            }
        }
    }
     public void displayZoo(int habitatChoice) {
    if (animals.isEmpty()) {
        System.out.println("The zoo is empty.");
    } else {
        System.out.println("Zoo Animals:");
        for (Animal animal : animals) {
            boolean display = true;
            if (habitatChoice != 0) {
                if ((habitatChoice == 1 && !(animal instanceof Bird)) ||
                    (habitatChoice == 2 && !(animal instanceof Fish)) ||
                    (habitatChoice == 3 && !(animal instanceof Mammal))) {
                    display = false;
                }
            }
            if (display) {
                System.out.print("Name: " + animal.name + ", Age: " + animal.age + ", Weight: " + animal.weight);
                if (animal instanceof Bird) {
                    System.out.println(", Wingspan: " + ((Bird) animal).wingspan);
                } else {
                    System.out.println();
                }
            }
        }
    }
}

        public void startZooManager() {
    Scanner scanner = new Scanner(System.in);
    int choice;
    int habitatChoice = 0;
    do {
        System.out.println("\nZoo Management System Menu:");
        System.out.println("1. View all animals in the zoo");
        System.out.println("2. Add animal to the zoo");
        System.out.println("3. Simulate zoo");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nSelect the habitat (1: Mountain, 2: Aquarium, 3: Forest, 0: Show all animals): ");
                habitatChoice = scanner.nextInt();
                displayZoo(habitatChoice);
                break;
            case 2:
                addAnimal(scanner);
                break;
            case 3:
                simulateZoo();
                break;
            case 4:
                System.out.println("Exiting Zoo Management System. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    } while (choice != 4);
    scanner.close();
}
     
    public void addAnimal(Scanner scanner) {
    System.out.println("Enter animal type (1: Mammal, 2: Bird, 3: Fish): ");
    int animalType = scanner.nextInt();
    System.out.println("Enter animal name: ");
    String name = scanner.next();
    System.out.println("Enter animal age: ");
    int age = scanner.nextInt();

    switch (animalType) {
        case 1:
            System.out.println("Enter animal weight: ");
            double mammalWeight = scanner.nextDouble();
            animals.add(new Mammal(name, age, mammalWeight));
            break;
        case 2:
            System.out.println("Enter bird weight: ");
            double birdWeight = scanner.nextDouble();
            System.out.println("Enter bird wingspan: ");
            double wingspan = scanner.nextDouble();
            animals.add(new Bird(name, age, birdWeight, wingspan));
            break;
        case 3:
            System.out.println("Enter animal weight: ");
            double fishWeight = scanner.nextDouble();
            animals.add(new Fish(name, age, fishWeight));
            break;
        default:
            System.out.println("Invalid animal type.");
    }
}
}


