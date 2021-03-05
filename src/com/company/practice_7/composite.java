package com.company.practice_7;
import java.util.ArrayList;
import java.util.List;
interface Vehicle {
    void draw(String color);
}
class Train implements Vehicle {
    public void draw(String color) {
        System.out.println("Train color: " + color);
    }
}
class Motorcycle implements Vehicle {
    public void draw(String color) {
        System.out.println("Motorcycle color: " + color);
    }
}
class Drawing implements Vehicle {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void add(Vehicle s){
        this.vehicles.add(s);
    }
    public void clear(){
        System.out.println();
        this.vehicles.clear();
    }

    @Override
    public void draw(String color) {
        for(Vehicle vehicle : vehicles) {
            vehicle.draw(color);
        }
    }
}
public class composite {
    public static void main(String[] args){
        Vehicle train = new Train();
        Vehicle motorcycle = new Motorcycle();
        Drawing drawing = new Drawing();
        drawing.add(train);
        drawing.add(motorcycle);
        drawing.draw("Green");
        drawing.clear();

        drawing.add(train);
        drawing.add(motorcycle);
        drawing.draw("Red");
        drawing.clear();
    }
}
