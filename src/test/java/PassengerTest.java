import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger("Passenger", 2);
    }

    @Test
    public void hasBags() {
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void hasName(){
        assertEquals("Passenger", passenger.getName());
    }

    @Test
    public void flightStartsNull() {
        assertEquals(null, passenger.getFlight());
    }

    @Test
    public void seatStarts0(){
        assertEquals(0, passenger.getSeat());
    }

    @Test
    public void canSetFlight() throws ParseException {
        Flight flight = new Flight(new Plane(PlaneType.BOEING737), "BA8814", "GLA", "LHR", "12:30, 08/02/2019");
        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void canSetSeat() {
        passenger.setSeat(3);
        assertEquals(3, passenger.getSeat());
    }
}
