package com.company.practice_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public HarryPotter harryPotter(){
        HarryPotter harryPotter = new HarryPotter();
        harryPotter.setMagicMethod("Экспекто Патронум");
        return harryPotter;
    }
    @Bean
    public RonWeesly ronWeesly(){
        RonWeesly ronWeesly = new RonWeesly();
        ronWeesly.setMagicMethod("Вингардум Левиоса");
        return ronWeesly;
    }
    @Bean
    public Voldemort voldemort(){
        Voldemort voldemort = new Voldemort();
        voldemort.setMagicMethod("Авада Кедавра");
        return voldemort;
    }
}
