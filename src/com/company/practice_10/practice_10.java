package com.company.practice_10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

interface Magican {
    void doMagic();
}
@Component
class HarryPotter implements Magican{
    String magicMethod;
    @Override
    public void doMagic() {
        System.out.println(magicMethod);
    }

    public void setMagicMethod(String magicMethod) {
        this.magicMethod = magicMethod;
    }
}
@Component
class RonWeesly implements Magican{
    String magicMethod;
    @Override
    public void doMagic() {
        System.out.println(magicMethod);
    }
    public void setMagicMethod(String magicMethod) {
        this.magicMethod = magicMethod;
    }
}
@Component
class Voldemort implements Magican{
    String magicMethod;
    @Override
    public void doMagic() {
        System.out.println("Авада Кедавра");
    }
    public void setMagicMethod(String magicMethod) {
        this.magicMethod = magicMethod;
    }
}


public class practice_10 {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        HarryPotter harryPotter = context.getBean(HarryPotter.class);
        RonWeesly ronWeesly = context.getBean(RonWeesly.class);
        Voldemort voldemort = context.getBean(Voldemort.class);

        harryPotter.doMagic();
        ronWeesly.doMagic();
        voldemort.doMagic();
    }
}
