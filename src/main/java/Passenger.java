public class Passenger {
    private String name;
    private int bags;
    private Flight flight;
    private int seat;

    public Passenger(String name, int bags) {
        this.name = name;
        this.bags = bags;
    }

    public String getName() {
        return name;
    }

    public int getBags() {
        return bags;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeat() {
        return seat;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
