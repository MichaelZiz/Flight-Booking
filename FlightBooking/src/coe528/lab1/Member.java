package coe528.lab1;

public class Member extends Passenger {

    private int yearsOfMembership;
    private double discount;

    public Member(String name, int age, int yrsm) {
        super(name, age);//call the superclass
        yearsOfMembership = yrsm;
    }

    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) { //years of membership greater than 5

            discount = p * 0.5; // apply discount; ticket set price 

        } else if (yearsOfMembership > 1 && yearsOfMembership <= 5) { // membership between 1 and 5
            discount = p * 0.9; //apply discount ;

        } else if (yearsOfMembership <= 1) {//membership less than 1
            discount = p * 1.0;// apply discount
        }
        //System.out.println(discount);
        return discount;
       
    }

}
