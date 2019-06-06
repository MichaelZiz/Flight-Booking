package coe528.lab1;

public abstract class Passenger {

    protected String name;
    protected int age;// protected variables for use in child class 

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double applyDiscount(double p);// abstract method to be implemented in child classes

}
