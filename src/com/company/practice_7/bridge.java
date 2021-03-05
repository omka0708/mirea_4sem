package com.company.practice_7;
interface Engine {
    void setEngine();
}
abstract class Car {
    protected Engine engine;
    public Car(Engine engine){
        this.engine = engine;
    }
    abstract public void setEngine();
}
class SportCar extends Car {
    public SportCar(Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("SportCar engine: ");
        engine.setEngine();
    }
}
class MuscleCar extends Car {
    public MuscleCar(Engine engine) {
        super(engine);
    }
    public void setEngine() {
        System.out.print("MuscleCar engine: ");
        engine.setEngine();
    }
}
class SportEngine implements Engine {
    public void setEngine(){
        System.out.println("sport");
    }
}
class MuscleEngine implements Engine {
    public void setEngine(){
        System.out.println("muscle");
    }
}
public class bridge {
    public static void main(String[] args){
        Car sportCar = new SportCar(new SportEngine());
        sportCar.setEngine();
        Car muscleCar = new MuscleCar(new MuscleEngine());
        muscleCar.setEngine();
    }
}
