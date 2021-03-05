package com.company.practice_6;

abstract class Tea {
    void makeTea(){
        System.out.println("Чай делается...");
    }
}
enum TeaType {
    GREEN,
    BLACK,
    OOLONG,
    PUER
}
class ItalianGreenTea extends Tea {}
class ItalianBlackTea extends Tea {}
class ItalianOolongTea extends Tea {}
class ItalianPuerTea extends Tea {}

class AmericanGreenTea extends Tea {}
class AmericanBlackTea extends Tea {}
class AmericanOolongTea extends Tea {}
class AmericanPuerTea extends Tea {}

abstract class TeaShop {
    void orderTea(TeaType type){
        Tea tea = createTea(type);
        tea.makeTea();
        switch (type){
            case BLACK:
                System.out.println("Ваш чёрный чай! Спасибо, приходите ещё!");
                break;
            case GREEN:
                System.out.println("Ваш зелёный чай! Спасибо, приходите ещё!");
                break;
            case OOLONG:
                System.out.println("Ваш чай улун! Спасибо, приходите ещё!");
                break;
            case PUER:
                System.out.println("Ваш чай пуэр! Спасибо, приходите ещё");
                break;
        }
    }
    abstract Tea createTea(TeaType type);
}
class ItalianTeaShop extends TeaShop {

    @Override
    Tea createTea(TeaType type) {
        System.out.println("Добро пожаловать в итальянскую чайную!");
        Tea tea = null;
        switch (type){
            case GREEN:
                tea = new ItalianGreenTea();
                break;
            case BLACK:
                tea = new ItalianBlackTea();
                break;
            case OOLONG:
                tea = new ItalianOolongTea();
                break;
            case PUER:
                tea = new ItalianPuerTea();
                break;
        }
        return tea;
    }
}
class AmericanTeaShop extends TeaShop {

    @Override
    Tea createTea(TeaType type) {
        System.out.println("Добро пожаловать в американскую чайную!");
        Tea tea = null;
        switch (type){
            case GREEN:
                tea = new AmericanGreenTea();
                break;
            case BLACK:
                tea = new AmericanBlackTea();
                break;
            case OOLONG:
                tea = new AmericanOolongTea();
                break;
            case PUER:
                tea = new AmericanPuerTea();
                break;
        }
        return tea;
    }
}
public class factory_method {
    public static void main(String[] args){
        TeaShop italianTeaShop = new ItalianTeaShop();
        italianTeaShop.orderTea(TeaType.PUER);
        italianTeaShop.orderTea(TeaType.BLACK);
        System.out.println("---------------------------------------");
        TeaShop americanTeaShop = new AmericanTeaShop();
        americanTeaShop.orderTea(TeaType.OOLONG);
        americanTeaShop.orderTea(TeaType.GREEN);
    }
}
