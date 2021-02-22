package com.company.practice_5;

public class OnDemandHolderSingleton {
    public static class SingletonHolder{
        public static final OnDemandHolderSingleton HOLDER_INSTANCE = new OnDemandHolderSingleton();
    }
    public static OnDemandHolderSingleton getInstance(){
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
// Объект инициализируется при первом вызове метода getInstance(),
// с ленивой инициализацией, но невозможно использовать для нестатических полей класса
