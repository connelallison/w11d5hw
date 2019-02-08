public class FlightManager {
    public static void sortPassengers(Flight flight){
        Passenger tempPassenger;
        for (int i = 0; i < flight.passengersCount() ; i++) {
            for (int j = 1; j < flight.passengersCount()-i ; j++) {
                if (flight.getPassengers().get(j - 1).getSeat() > flight.getPassengers().get(j).getSeat()) {
                    tempPassenger = flight.getPassengers().get(j - 1);
                    flight.getPassengers().set(j - 1, flight.getPassengers().get(j));
                    flight.getPassengers().set(j, tempPassenger);
                }
            }
        }
    }

    public static Passenger findBySeat(Flight flight, int seat){
        sortPassengers(flight);
        if (flight.getPassengers().size() == 0){
            return null;
        }
        if (flight.getPassengers().get(0).getSeat() > seat){
            return null;
        }
        if (flight.getPassengers().get(flight.getPassengers().size()-1).getSeat() < seat){
            return null;
        }
        return binarySearch(flight, seat, 0, flight.getPassengers().size()-1);

    }
    private static Passenger binarySearch(Flight flight, int seat, int left, int right){
        if (right >= left){
            int midway = left + (right-left)/2;

            if (flight.getPassengers().get(midway).getSeat() == seat){
                return flight.getPassengers().get(midway);
            }

            if (flight.getPassengers().get(midway).getSeat() < seat){
                return binarySearch(flight, seat, midway+1, right);
            }

            if (flight.getPassengers().get(midway).getSeat() > seat){
                return binarySearch(flight, seat, left, midway-1);
            }
        }
        return null;
    }

    public static int getBagWeightOfPassenger(Passenger passenger){
        return passenger.getFlight().getPlane().getPlaneType().getWeightPerBag() * passenger.getBags();
    }

    public static int getTotalBagWeight(Flight flight) {
        int total = 0;
        for (int i = 0; i < flight.passengersCount(); i++) {
            total += getBagWeightOfPassenger(flight.getPassengers().get(i));
        }
        return total;
    }

    public static int getRemainingBaggageWeight(Flight flight) {
        return (flight.getPlane().getWeight()/2) - getTotalBagWeight(flight);
    }
}


