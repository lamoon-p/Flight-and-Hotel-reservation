import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Flight> flights = new ArrayList<>();
    private List<Hotel> hotels = new ArrayList<>();
    private List<FlightReserve> flightReserves = new ArrayList<>();
    private List<HotelReserve> hotelReserves = new ArrayList<>();

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
            System.out.println("Room available: " + hotel.getRoomAvailable());
        }
    }

    // search flight and hotel from list


    // book and cancel reservation
    public void bookFlight(int flightNumber, int pax) {

        FlightReserve flightReserve = new FlightReserve();
        flightReserve.setFlightNumber(flightNumber);
        flightReserve.setPax(pax);
        flightReserve.setBookingNumber(generateBookingNumber());
        // deduct available seat
    }

    public void bookHotel(int hotelID, int pax) {

        HotelReserve hotelReserve = new HotelReserve();
        hotelReserve.setHotelID(hotelID);
        hotelReserve.setPax(pax);
        hotelReserve.setBookingNumber(generateBookingNumber());
    }

    public void cancelReservation(int bookingNumber) {

        for (FlightReserve flightReserve : flightReserves) {
            if (flightReserve.getBookingNumber() == bookingNumber) {
                flightReserves.remove(flightReserve);
                System.out.println("Booking Number: " + bookingNumber + "\nFlight reservation cancelled!");
            }
        }

        for (HotelReserve hotelReserve : hotelReserves) {
            if (hotelReserve.getBookingNumber() == bookingNumber) {
                hotelReserves.remove(hotelReserve);
                System.out.println("Booking Number: " + bookingNumber + "\nHotel reservation cancelled!");
            }
        }
    }

    public int generateBookingNumber() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate now = LocalDate.now();
        String dateString = now.format(formatter);

        double randomNumber = (Math.random()*1000000000);

        return concatenateDigits(randomNumber, dateString);
    }

    public int concatenateDigits(double randomNumber, String dateString) {

        String s1 = Double.toString(randomNumber);

        String s = s1 + dateString;

        return Integer.parseInt(s);
    }
}