
package coe528.lab1;


public class NonMember extends Passenger {

    private double discount;

    public NonMember(String name, int age) {
        super(name, age);// call super constructor
    }

    @Override
    public double applyDiscount(double p) {
        if (super.age > 65) {// discount applied if age is greater than 65
            discount = 0.9 * p;
        } else {
            discount = 1.0 * p;//no discount for non members under 65
        }

        
        return discount;
    }

}
