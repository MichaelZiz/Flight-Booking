package coe528.lab1;

public class Ticket {

    private Passenger passenger;
    private Flight flight;
    private double price;
    private int num;
    private static int number = 0;// static variable to keep track of ticket numbers

    public Ticket(Passenger passenger, Flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        number = number + 1;//ticket number increases with each booking 
        num=number;//setting the static variable to a placeholder for the class
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        setPrice(price);// call set price for discounted price
        return price;
    }

    public void setPrice(double price) {
        this.price = passenger.applyDiscount(price);//new price 
       // System.out.println(price);//CHECK this out
    }

    public static int getNumber() {
        
        return number;
    }

    public static void setNumber(int number) {
        number = number + 1;// dummy statement never used
    }

    @Override
    public String toString() {
        return "Passenger: " + passenger.name + " ticket number: " + num + ", " + flight.toString() + " ticket price: $" + getPrice(); //
        
    }

}
