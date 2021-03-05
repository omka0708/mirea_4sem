package com.company.practice_8;
// В этом паттерне есть четыре термина,
// команды (command), приемник команд (receiver),
// вызывающий команды (invoker) и клиент (client).

/* receiver */
class Light {
    public Light(){}
    void turnOn(){
        System.out.println("Свет включен");
    }
    void turnOff(){
        System.out.println("Свет выключен");
    }
}

/* command */
interface MyCommand {
    void execute();
}

class TurnOnLightMyCommand implements MyCommand {
    private final Light light;

    TurnOnLightMyCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }
}
class TurnOffLightMyCommand implements MyCommand {
    private final Light light;

    TurnOffLightMyCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOff();
    }
}

/* invoker */
class Switch {
    private final MyCommand flipUpMyCommand;
    private final MyCommand flipDownMyCommand;

    Switch(MyCommand flipUpMyCommand, MyCommand flipDownMyCommand){
        this.flipUpMyCommand = flipUpMyCommand;
        this.flipDownMyCommand = flipDownMyCommand;
    }
    void flipUp(){
        flipUpMyCommand.execute();
    }
    void flipDown(){
        flipDownMyCommand.execute();
    }
}
public class command {
    public static void main(String[] args){
        Light light = new Light();
        MyCommand switchUp = new TurnOnLightMyCommand(light);
        MyCommand switchDown = new TurnOffLightMyCommand(light);
        Switch _switch = new Switch(switchUp, switchDown);
        _switch.flipUp();
        _switch.flipDown();
    }
}
