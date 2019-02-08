import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNum;
    private String departing;
    private String destination;
    private Date departureDate;

    public Flight(Plane plane, String flightNum, String departing, String destination, String departureDateString) throws ParseException {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNum = flightNum;
        this.departing = departing;
        this.destination = destination;
        this.departureDate = new SimpleDateFormat("HH:mm, dd/MM/yyyy").parse(departureDateString);;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String getDeparting() {
        return departing;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public int passengersCount() {
        return passengers.size();
    }

    public int emptySeatsCount() {
        return plane.getCapacity() - passengersCount();
    }

    public boolean emptySeats(){
        return emptySeatsCount() > 0;
    }

    public boolean isEmpty(int seat){
        for (int i = 0; i < passengersCount(); i++) {
            if (passengers.get(i).getSeat() == seat){
                return false;
            }
        }
        return true;
    }
    public int getRandomEmptySeat() {
        if (emptySeats()){
            int randomSeat = new Random().nextInt(plane.getCapacity()-1)+1;
            if (isEmpty(randomSeat)){
                return randomSeat;
            } else {
                return getRandomEmptySeat();
            }
        }
        return 0;
    }

    public void book(Passenger passenger) {
        if (emptySeats()){
            passengers.add(passenger);
            passenger.setFlight(this);
            passenger.setSeat(getRandomEmptySeat());
        }
    }
}
