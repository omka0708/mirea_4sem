package com.company.practice_6;

interface Button {}
interface Select {}
interface TextField {}

class WindowsButton implements Button {}
class WindowsSelect implements Select {}
class WindowsTextField implements TextField {}

class MacButton implements Button {}
class MacSelect implements Select {}
class MacTextField implements TextField {}

interface GUIFactory {
    void createButton();
    void createTextField();
    void createSelect();
}

class WindowsGUIFactory implements GUIFactory {
    WindowsGUIFactory(){
        System.out.println("Создание GUI для Windows");
    }
    @Override
    public void createButton() {
        System.out.println("Создание Button для Windows");
        new WindowsButton();
    }

    @Override
    public void createTextField() {
        System.out.println("Создание TextField для Windows");
        new WindowsTextField();
    }

    @Override
    public void createSelect() {
        System.out.println("Создание Select для Windows");
        new WindowsSelect();
    }
}
class MacGUIFactory implements GUIFactory {
    MacGUIFactory(){
        System.out.println("Создание GUI для Mac");
    }

    @Override
    public void createButton() {
        System.out.println("Создание Button для Mac");
        new MacButton();
    }

    @Override
    public void createTextField() {
        System.out.println("Создание TextField для Mac");
        new MacTextField();
    }
    @Override
    public void createSelect() {
        System.out.println("Создание Select для Mac");
        new MacSelect();
    }
}
class OrderTeaForm {

    OrderTeaForm(GUIFactory factory) {
        System.out.println("Создание формы заказа чая...");
        factory.createTextField();
        factory.createButton();
        factory.createSelect();
    }
}
public class abstract_factory {
    static void drawOrderTeaForm() {
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory guiFactory;

        if (osName.startsWith("win")) {
            guiFactory = new WindowsGUIFactory();
        } else if (osName.startsWith("mac")) {
            guiFactory = new MacGUIFactory();
        } else {
            System.out.println("Unknown OS, can't draw form :( ");
            return;
        }
        new OrderTeaForm(guiFactory);
    }
    public static void main(String[] args){
        drawOrderTeaForm();
    }
}
