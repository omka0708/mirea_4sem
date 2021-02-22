package com.company.practice_5;

public class StaticFieldSingleton {
    public static final StaticFieldSingleton INSTANCE = new StaticFieldSingleton();
}
// Потокобезопасный, с простой реализацией, но без ленивой инициализации
