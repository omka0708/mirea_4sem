package com.company.practice_6;
interface Copyable {
    Copyable copy();
}
class MyObject implements Copyable {
    private Type type;
    enum Type{
        ONE, TWO
    }
    MyObject(){
        setType(Type.ONE);
    }
    @Override
    public Copyable copy() {
        return new MyObject();
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Object type: " + type;
    }
}
public class prototype {
    public static void main(String[] args){
        MyObject prototype = new MyObject();
        MyObject clone = (MyObject) prototype.copy();
        clone.setType(MyObject.Type.TWO);
        System.out.print(prototype + "\n" + clone);
    }
}
