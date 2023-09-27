import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Flight> flights = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();
    private static List<FlightReserve> flightReserves = new ArrayList<>();
    private static List<HotelReserve> hotelReserves = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<FlightReserve> getFlightReserves() {
        return flightReserves;
    }

    public void setFlightReserves(List<FlightReserve> flightReserves) {
        this.flightReserves = flightReserves;
    }

    public List<HotelReserve> getHotelReserves() {
        return hotelReserves;
    }

    public void setHotelReserves(List<HotelReserve> hotelReserves) {
        this.hotelReserves = hotelReserves;
    }

    public void retrieveFlight() {

        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("From: " + flight.getOrigin() + " To: " + flight.getDestination());
            System.out.println("Seat available: " + flight.getSeatAvailable());
        }
    }

    public void retrieveHotel() {

        for (Hotel hotel : hotels) {
            System.out.println("Location: " + hotel.getLocation());
            System.out.println("Price: " + hotel.getPrice());
            System.out.println("Room available: " + hotel.getGuestAvailable());
        }
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added!");
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        System.out.println("Hotel added!");
    }

    // to do next search by time window.
    public void searchFlightAndHotel(String keyword) {

        for (Flight flight : flights) {
            if (flight.getFlightNumber() == Integer.parseInt(keyword)) {
                System.out.println("Found matched flight number!");
                flightSearchFound(flight);
            }
            if (flight.getOrigin().matches(keyword)) {
                System.out.println("Found matched flight origin!");
                flightSearchFound(flight);
            }
            if (flight.getDestination().matches(keyword)) {
                System.out.println("Found matched flight destination!");
                flightSearchFound(flight);
            }
        }

        for (Hotel hotel : hotels) {
            if (hotel.getHotelID() == Integer.parseInt(keyword)) {
                System.out.println("Found matched hotel ID");
                hotelSearchFound(hotel);
            }
            if (hotel.getLocation().matches(keyword)) {
                System.out.println("Found matched hotel location");
                hotelSearchFound(hotel);
            }
        }
        // I want to add alert for not found result.
    }

    public void flightSearchFound(Flight flight) {

        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("From: " + flight.getOrigin() + " To: " + flight.getDestination());
        System.out.println("Departure at " + flight.getDepartureTime());
        System.out.println("Available " + flight.getSeatAvailable() + " seat(s)");
    }

    public void hotelSearchFound(Hotel hotel) {

        System.out.println("Hotel ID: " + hotel.getHotelID());
        System.out.println("Location: " + hotel.getLocation());
        System.out.println("Check in on: " + hotel.getCheckIn());
        System.out.println("Price: " + hotel.getPrice());
        System.out.println("Available " + hotel.getGuestAvailable() + " guest(s)");
    }


    public long bookFlight(int flightNumber, int pax) {

        FlightReserve flightReserve = new FlightReserve();
        flightReserve.setFlightNumber(flightNumber);
        flightReserve.setPax(pax);
        long bookingNumber = generateBookingNumber();
        flightReserve.setBookingNumber(bookingNumber);
        flightReserves.add(flightReserve);

        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                flight.setSeatAvailable(flight.getSeatAvailable() - pax);
            }
        }
        System.out.println("Flight number " + flightNumber + " booked for " + pax + " passenger(s) " + "\nYour Booking Number is: " + flightReserve.getBookingNumber());
        return bookingNumber;
    }

    public long bookHotel(int hotelID, int pax) {

        HotelReserve hotelReserve = new HotelReserve();
        hotelReserve.setHotelID(hotelID);
        hotelReserve.setPax(pax);
        long bookingNumber = generateBookingNumber();
        hotelReserve.setBookingNumber(bookingNumber);
        hotelReserves.add(hotelReserve);

        for (Hotel hotel : hotels) {
            if (hotel.getHotelID() == hotelID) {
                hotel.setGuestAvailable(hotel.getGuestAvailable() - pax);
            }
        }
        System.out.println("Hotel ID " + hotelID + " booked for " + pax + " guest(s) " + "\nYour Booking Number is: " + hotelReserve.getBookingNumber());
        return bookingNumber;
    }

    public void cancelReservation(long bookingNumber) {

        if (flightReserves.removeIf(e -> e.getBookingNumber() == bookingNumber)) {

            addBackSeatAvailable();
            System.out.println("Booking Number: " + bookingNumber + " Flight reservation cancelled!");
        }

        if (hotelReserves.removeIf(e -> e.getBookingNumber() == bookingNumber)) {

            addBackGuestAvailable();
            System.out.println("Booking Number: " + bookingNumber + " Hotel reservation cancelled!");
        }
    }

    private void addBackSeatAvailable() {

        for (FlightReserve flightReserve : flightReserves) {

            for (Flight flight : flights) {

                if (flight.getFlightNumber() == flightReserve.getFlightNumber()) {
                    flight.setSeatAvailable(flight.getSeatAvailable() + flightReserve.getPax());
                }
            }
        }
    }

    private void addBackGuestAvailable(){

        for (HotelReserve hotelReserve : hotelReserves) {

            for (Hotel hotel : hotels) {
                if (hotel.getHotelID() == hotelReserve.getHotelID()) {
                    hotel.setGuestAvailable(hotel.getGuestAvailable() + hotelReserve.getPax());
                }
            }
        }
    }

    private long generateBookingNumber() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate now = LocalDate.now();
        String dateString = now.format(formatter);

        long randomNumber = (long) (Math.random()*1000000000);

        return concatenateDigits(randomNumber, dateString);
    }

    private long concatenateDigits(long randomNumber, String dateString) {

        String s1 = Long.toString(randomNumber);

        String s = s1 + dateString;

        return Long.parseLong(s);
    }
}