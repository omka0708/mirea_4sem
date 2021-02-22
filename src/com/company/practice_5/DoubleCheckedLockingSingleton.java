package com.company.practice_5;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;
    public static DoubleCheckedLockingSingleton getInstance(){
        DoubleCheckedLockingSingleton localInstance = instance;
        if (localInstance == null){
            synchronized (DoubleCheckedLockingSingleton.class){
                localInstance = instance;
                if (localInstance == null)
                    instance = localInstance = new DoubleCheckedLockingSingleton();
            }
        }
        return localInstance;
    }
}
// Потокобезопасный, без лишней синхронизации (как в Synchronized Accessor),
// но поддерживается только с JDK 1.5 [5]