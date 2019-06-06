package coe528.lab1;

public class Flight {

    private int flightNumber;
    private int capacity;
    public int numberOfSeatsLeft;// public for call in manager class
    private double originalPrice;
    private String origin;
    private String destination;
    private String departureTime;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public boolean bookASeat() {

        if (numberOfSeatsLeft <= 0) //Check if there are seats available
        {  
            return false;
          
        } else { //seats available 
            numberOfSeatsLeft = numberOfSeatsLeft - 1;// decrement seats on the aircraft
           // System.out.println(numberOfSeatsLeft); //Can be removed?
           
            return true;
        }

    }

    public Flight(int flightNumber, int capacity, double originalPrice,
            String origin, String destination, String departureTime) throws IllegalArgumentException {
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        numberOfSeatsLeft = capacity;

        if (origin.equals(destination)) // if statements to check argument exceptions
        {
            throw new IllegalArgumentException("invalid: origin and destination are the same");
        } else if (flightNumber < 0) {
            throw new IllegalArgumentException("invalid: flight number must be positive");
        } else if (capacity < 0) {
            throw new IllegalArgumentException("invalid: capacity must be greater than 0");
        } else if (originalPrice < 0) {
            throw new IllegalArgumentException("invalid: price must be greater 0");
        }

    }

    @Override
    public String toString() {
        return "Flight: " + flightNumber + "," + origin + " to "
                + destination + "," + departureTime + ", original price: $" + originalPrice;
    }

}
