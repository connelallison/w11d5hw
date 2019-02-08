import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;

    @Before
    public void setUp() throws ParseException {
        plane = new Plane(PlaneType.BOEING737);
        passenger1 = new Passenger("Passenger1", 2);
        passenger2 = new Passenger("Passenger2", 1);
        passenger3 = new Passenger("Passenger3", 1);
        passenger4 = new Passenger("Passenger4", 1);
        passenger5 = new Passenger("Passenger5", 1);
        flight = new Flight(plane, "BA8814", "GLA", "LHR", "12:30, 08/02/2019");
        flight.book(passenger1);
        flight.book(passenger2);
        flight.book(passenger3);
        flight.book(passenger4);
        flight.book(passenger5);
    }

    @Test
    public void canSortPassengers() {
        FlightManager.sortPassengers(flight);
        assertEquals(true, flight.getPassengers().get(0).getSeat() < flight.getPassengers().get(1).getSeat());
        assertEquals(true, flight.getPassengers().get(1).getSeat() < flight.getPassengers().get(2).getSeat());
        assertEquals(true, flight.getPassengers().get(2).getSeat() < flight.getPassengers().get(3).getSeat());
        assertEquals(true, flight.getPassengers().get(3).getSeat() < flight.getPassengers().get(4).getSeat());
    }

    @Test
    public void canFindPassengerBySeat() {
        assertEquals(passenger1, FlightManager.findBySeat(flight, passenger1.getSeat()));
    }

    @Test
    public void canGetBagWeightOfPassenger() {
        assertEquals(80, FlightManager.getBagWeightOfPassenger(passenger1));
    }

    @Test
    public void canGetTotalBagWeightOfFlight() {
        assertEquals(240, FlightManager.getTotalBagWeight(flight));
    }

    @Test
    public void canGetRemainingBaggageWeight() {
        assertEquals(35027, FlightManager.getRemainingBaggageWeight(flight));
    }
}
