import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import static org.junit.Assert.assertEquals;

public class FlightTest {
    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void setUp() throws ParseException {
        plane = new Plane(PlaneType.BOEING737);
        passenger1 = new Passenger("Passenger1", 2);
        passenger2 = new Passenger("Passenger2", 1);
        flight = new Flight(plane, "BA8814", "GLA", "LHR", "12:30, 08/02/2019");
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasDeparting() {
        assertEquals("GLA", flight.getDeparting());
    }

    @Test
    public void hasDestination() {
        assertEquals("LHR", flight.getDestination());
    }

    @Test
    public void hasFlightNum() {
        assertEquals("BA8814", flight.getFlightNum());
    }

    @Test
    public void hasDepartureDate() {
        assertEquals("Fri Feb 08 12:30:00 GMT 2019", flight.getDepartureDate().toString());
    }

    @Test
    public void passengersStartsEmpty() {
        assertEquals(0, flight.passengersCount());
    }

    @Test
    public void canGetEmptySeatsCount(){
        assertEquals(215, flight.emptySeatsCount());
    }


    @Test
    public void canBookPassenger() {
        assertEquals(0, flight.passengersCount());
        assertEquals(215, flight.emptySeatsCount());
        flight.book(passenger1);
        assertEquals(flight, passenger1.getFlight());
        assertEquals(1, flight.passengersCount());
        assertEquals(214, flight.emptySeatsCount());
    }
}
