// Consider two interfaces, Volume and SurfaceArea with methods getVolume() and getSurfaceArea() respectively. Class ‘Cylinder’ implements both Volume and SurfaceArea and implements their methods. 

// The class contains their required dimensions as data members. Write a program which inputs its dimensions and prints its volume and surface area. 

// Create classes ‘Cone’and ‘Sphere’ that implements both the interfaces. In main class, ask user which shape volume and area needs to be calculated. Use switch case. 



package Abstraction.Interfaces;

import java.util.Scanner;

// Interface for Volume
interface Volume {
    double getVolume();
}

// Interface for Surface Area
interface SurfaceArea {
    double getSurfaceArea();
}

// Class Cylinder implementing Volume and SurfaceArea interfaces
class Cylinder implements Volume, SurfaceArea {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

// Class Cone implementing Volume and SurfaceArea interfaces
class Cone implements Volume, SurfaceArea {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (Math.PI * radius * radius * height) / 3;
    }

    @Override
    public double getSurfaceArea() {
        return Math.PI * radius * (radius + Math.sqrt(radius * radius + height * height));
    }
}

// Class Sphere implementing Volume and SurfaceArea interfaces
class Sphere implements Volume, SurfaceArea {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * radius * radius * radius) / 3;
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

public class Cylinder1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a shape (1: Cylinder, 2: Cone, 3: Sphere):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter radius and height of the cylinder:");
                double cylinderRadius = scanner.nextDouble();
                double cylinderHeight = scanner.nextDouble();
                Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                System.out.println("Volume of the cylinder: " + cylinder.getVolume());
                System.out.println("Surface area of the cylinder: " + cylinder.getSurfaceArea());
                break;
            case 2:
                System.out.println("Enter radius and height of the cone:");
                double coneRadius = scanner.nextDouble();
                double coneHeight = scanner.nextDouble();
                Cone cone = new Cone(coneRadius, coneHeight);
                System.out.println("Volume of the cone: " + cone.getVolume());
                System.out.println("Surface area of the cone: " + cone.getSurfaceArea());
                break;
            case 3:
                System.out.println("Enter radius of the sphere:");
                double sphereRadius = scanner.nextDouble();
                Sphere sphere = new Sphere(sphereRadius);
                System.out.println("Volume of the sphere: " + sphere.getVolume());
                System.out.println("Surface area of the sphere: " + sphere.getSurfaceArea());
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    @Override
    public String toString() {
        return "Cylinder1 []";
    }
}
