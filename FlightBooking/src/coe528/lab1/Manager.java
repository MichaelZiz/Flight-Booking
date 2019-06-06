package coe528.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    private ArrayList<Flight> flights = new ArrayList<Flight>();//create arraylist since unknown # of flights and tickets
    private ArrayList<Ticket> issuedtickets = new ArrayList<Ticket>();
    private int flightNum, cap, k = 0;
    private String orig, dest, depart;
    private double price;

    public void createflight() {
        int x = 0;
        System.out.println("Create Flight\n Enter Flight number:");
        
        while(x==0){
        Scanner c = new Scanner(System.in);
        if(c.hasNextInt()==true){//enter flightnumber, prompt user to get apporiate input
        flightNum = c.nextInt();
        System.out.println("Flight #: " + flightNum);
        x=1;
        }
        else System.out.println("enter an integer");
        }

        System.out.println("Enter Capacity");//enter capacity

        while (x == 1) {//prompt user to get apporiate input
            Scanner d = new Scanner(System.in);
            if (d.hasNextInt() == true) {
                cap = d.nextInt();
                System.out.println("Capacity :" + cap);
                x = 2;
            } else {
                System.out.println("enter an integer");
            }
        }

        System.out.println("Enter price: ex.600.00");//enter price
        while (x == 2) {//prompt user to get apporiate input
            Scanner d = new Scanner(System.in);
            if (d.hasNextDouble() == true) {
                price = d.nextDouble();//CHECK out price
                System.out.println("Price :" + price);
                x = 3;
            } else {
                System.out.println("enter an decimal number");
            }
        }

        System.out.println("Enter origin");//enter origin
        Scanner q = new Scanner(System.in);
        orig = q.nextLine();
        System.out.println("origin :" + orig);

        System.out.println("Enter Destination");//enter destination
        Scanner t = new Scanner(System.in);
        dest = t.nextLine();
        System.out.println("destination :" + dest);

        System.out.println("Enter departure date/time, ex 01/01/17 7:50pm");//enter depart time
        Scanner e = new Scanner(System.in);
        depart = e.nextLine();
        System.out.println("departure date/time :" + depart);

        try {//try and catch to solve illegal args
            flights.add(new Flight(flightNum, cap, price, orig, dest, depart));//add flight
            System.out.println(flights.get(k));
            k = k + 1;//increment k to display proper flight
            System.out.println("Flight created");
        } catch (IllegalArgumentException z) {
            System.out.println(z.getMessage()+"\n Flight not created");
        }

    }

    public void displayAvailableFlights(String origin, String destination) throws IllegalArgumentException {
        int j = 0;
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("origin and destination cannot be the same");
        } else {
            if (flights.size() > 0) {//check if flights exist
                for (int i = 0; i < flights.size(); i++) {//loop through flight array
                    if (flights.get(i) == null) {//check for null pointer exceptions
                        System.out.print("-");
                    } else if (flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination)
                            && flights.get(i).numberOfSeatsLeft>0) {//checking for origin and destinations and if seats available

                        System.out.println("Flights with available seats");
                        System.out.println(flights.get(i).toString());//print out the flight info
                        j++;//increment j to display flights available
                    }
                }
            } else {
                System.out.println("no flights");// flights less than or =0 no flights
            }

            System.out.println("Flights with available seats:" + j);
            System.out.println("flights and info displayed above");
        }
    }

    public Flight getFlight(int flightNum) {
        Flight y = null;//set flight holder to null
        for (int i = 0; i < flights.size(); i++) {//loops through flights
            if (flights.get(i) == null) {//null pointer exception just in case for alternate flights array with set size
                System.out.print("-\n not found");
            } else if (flights.get(i).getFlightNumber() == flightNum) {//check the flight number exists
                y = flights.get(i);//set holder to flights
            }//else if(flights.get(i).getFlightNumber() != flightNum){}//can add statement for clarification but no need

        }

        return y; //sysout print ln for object in main
    }

    public void bookSeat(int flightNumber, Passenger p) {
        int j = 0;
        for (int i = 0; i < flights.size(); i++) {//loop through flights
            if (flights.get(i) == null) {//null pointer check

                System.out.println(" ");
            }//else statement
            else if (flights.get(i).getFlightNumber() == flightNumber) {

                if (flights.get(i).bookASeat() == true) {//check if seats available

                    issuedtickets.add(new Ticket(p, flights.get(i), flights.get(i).getOriginalPrice()));//create ticket and add into arraylist
                    System.out.println(issuedtickets.get(issuedtickets.size() - 1).toString());//print out ticket info
                    j++;
                    //else statement to tell user no flight exists 
                } else {
                    System.out.println("Sorry Flight Full");
                }
            }
        }
        if (j == 0) {
            System.out.println("no flight exists or flight no longer exists");
        } else {
            System.out.println("Seat booked");
        }

    }

    public void getList() {
        for (int u = 0; u < issuedtickets.size(); u++) {
            System.out.println(issuedtickets.get(u).toString());
        }
    }

    public static void main(String[] args) {

        int x = 0;
        int b;
        Manager p = new Manager();

        do {
            System.out.println(" \n Press 1 to create a Flight\n Press 2 to Display Available Flights\n "
                    + "Press 3 to check Flights\n Press 4 to Book a Seat\n" + " Press 5 to Exit\n");
            
            Scanner v = new Scanner(System.in);
            if(v.hasNextInt()==true){
            b = v.nextInt();
            if (b == 1 || b == 2 || b == 3 || b == 4 || b == 5) {//if statements corresponding to user input

                if (b == 1) {//create a Flight
                    p.createflight();

                }

                if (b == 2) {//2 Display Available Flights
                    try {//try and catch for illegal args
                        String og, dt;
                        System.out.println("enter origin of flight");
                        Scanner d = new Scanner(System.in);
                        og = d.nextLine();
                        System.out.println("origin:" + og);

                        System.out.println("enter destination");

                        Scanner t = new Scanner(System.in);
                        dt = t.nextLine();
                        System.out.println("destination:" + dt);

                        p.displayAvailableFlights(og, dt);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }

                }
                if (b == 3) {//get flights
                    int fn, y = 0;
                    Flight a;
                    System.out.println("Enter Flight number to search");

                    while (y == 0) {//prompt user to get apporiate input

                        Scanner r = new Scanner(System.in);
                        if (r.hasNextInt() == true) {
                            fn = r.nextInt();
                            System.out.println("entered:" + fn);
                            y = 1;
                            a = p.getFlight(fn);
                            if (a == null) {
                                System.out.println("no flight exists");
                            } else {
                                System.out.println("\n found:\n" + a);
                            }
                        } else {
                            System.out.println("enter an integer please");
                        }

                    }

                }
                if (b == 4) {//booking a seat
                    int z = 0;

                    System.out.println("Is passenger an airlines member? (yes or no)");

                    while (z == 0) {//prompt user to get apporiate input
                        Scanner h = new Scanner(System.in);
                        if (h.hasNext("yes") == true || h.hasNext("no") == true) {

                            if ("yes".equals(h.nextLine())) //create a member account
                            {
                                int fn, age, yrsm, x3 = 0, x4 = 0, x5 = 0;//local variables to hold inputs
                                String name;

                                System.out.println("Enter flight number:");
                                while (x3 == 0) {//prompt user to get apporiate input
                                    Scanner q = new Scanner(System.in);
                                    if (q.hasNextInt() == true) {
                                        fn = q.nextInt();
                                        System.out.println("entered " + fn);

                                        Scanner j = new Scanner(System.in);
                                        System.out.println("Enter Name of passenger:");
                                        name = j.nextLine();

                                        System.out.println("Enter age of passenger:");
                                        while (x4 == 0) {//prompt user to get apporiate input
                                            Scanner i = new Scanner(System.in);
                                            if (i.hasNextInt() == true) {
                                                age = i.nextInt();
                                                System.out.println("enter years of membership");

                                                while (x5 == 0) {//prompt user to get apporiate input
                                                    Scanner ass =new Scanner(System.in);
                                                    if (ass.hasNextInt() == true) {
                                                        yrsm = ass.nextInt();
                                                        Member u = new Member(name, age, yrsm);//add
                                                        p.bookSeat(fn, u);
                                                        x5 = 1;
                                                    } else {
                                                        System.out.println("enter an integer");
                                                    }
                                                }

                                                x4 = 1;
                                            } else {
                                                System.out.println("enter an integer");
                                            }

                                        }
                                        x3 = 1;
                                    } else {
                                        System.out.println("enter an integer");
                                    }
                                }
                            } else {//non member
                                int nf, ag, x1, x2 = 0;
                                String nm;
                                x1 = 0;

                                System.out.println("Enter flight number:");

                                while (x1 == 0) {//prompt user to get apporiate input
                                    Scanner j = new Scanner(System.in);
                                    if (j.hasNextInt() == true) {
                                        nf = j.nextInt();
                                        System.out.println("Entered: " + nf);

                                        Scanner i = new Scanner(System.in);
                                        System.out.println("Enter Name of passenger:");
                                        nm = i.nextLine();

                                        System.out.println("Enter age of passenger:");
                                        while (x2 == 0) {//prompt user to get apporiate input
                                            Scanner l = new Scanner(System.in);
                                            if (l.hasNextInt() == true) {
                                                ag = l.nextInt();
                                                System.out.println("Entered: " + ag);
                                                NonMember o = new NonMember(nm, ag);// new nonmember
                                                p.bookSeat(nf, o);//book a seat
                                                x2 = 1;

                                            } else {
                                                System.out.println("enter an integer");
                                            }
                                        }
                                        x1 = 1;
                                    } else {
                                        System.out.println("enter an integer");
                                    }
                                }

                            }
                            z = 1;
                        } else {
                            System.out.println("enter 'yes' or 'no'");
                        }

                    }
                    //create a non member account

                }

                if (b == 5) {//exit program by breakin while loop
                    x = 6;
                    System.out.println("thank you, bye");
                }
            } else {
                System.out.println("Enter a valid number to access directory");
            }
            } else {System.out.println("invalid entry");}
        } while (x == 0);

    }
}
