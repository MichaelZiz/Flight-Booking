
package coe528.lab1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    
    @Test  
    public void testConstructor(){//test of valid constructor 
            Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
            String exp=new String("toronto");
            String exp1=new String("bogota"); 
            String exp2=new String("01/01/17 7:50pm");
            int exp3=1947,exp4=250;
            double exp5=600.0;
            String result1=instance.getOrigin(), result2=instance.getDestination(), result3=instance.getDepartureTime();
            int re1=instance.getFlightNumber(),re2=instance.getCapacity();
            double re3= instance.getOriginalPrice();
            
            assertEquals(exp, result1);
            assertEquals(exp1, result2);
            assertEquals(exp2, result3);
            assertEquals(exp3, re1);
            assertEquals(exp4, re2);
            assertEquals(exp5, re3,0.0);
    }
    @Test (expected = IllegalArgumentException.class)//test of invalid constructor
    public void testInvalidConstructor(){
        Flight instance = new Flight(1947,250,600.00,"toronto","toronto","01/01/17 7:50pm");
        
    }
    
    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        int expResult = 1947;
        int result = instance.getFlightNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int flightNumber = 1947;
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setFlightNumber(flightNumber);
        assertEquals(instance.getFlightNumber(),flightNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        int expResult = 250;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 250;
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setCapacity(capacity);
        assertEquals(instance.getCapacity(),capacity);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        double expResult = 600.0;
        double result = instance.getOriginalPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double originalPrice = 600.0;
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setOriginalPrice(originalPrice);
        assertEquals(instance.getOriginalPrice(),600.00,0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        String expResult = "toronto";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "toronto";
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setOrigin(origin);
        assertEquals(origin,instance.getOrigin());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        String expResult = "bogota";
        String result = instance.getDestination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "bogota";
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setDestination(destination);
        assertEquals(destination,instance.getDestination());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        String expResult = "01/01/17 7:50pm";
        String result = instance.getDepartureTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String departureTime = "01/01/17 7:50pm";
        Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        instance.setDepartureTime(departureTime);
        assertEquals(departureTime,instance.getDepartureTime());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
       Flight instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance;
        instance = new Flight(1947,250,600.00,"toronto","bogota","01/01/17 7:50pm");
        String expResult = "Flight: "+1947+","+ "toronto"+ " to "+ 
                "bogota"+","+ "01/01/17 7:50pm"+", original price: $"+600.00;
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
