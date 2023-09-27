import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Flight flight1 = new Flight();
        flight1.setFlightNumber(894125684);
        flight1.setOrigin("Bangkok");
        flight1.setDestination("Dubai");
        flight1.setDepartureTime(LocalDateTime.of(2023, 03, 22, 10,30));
        flight1.setArrivalTime(LocalDateTime.of(2023, 03, 22, 17, 00));
        flight1.setPrice(12000);
        flight1.setSeatAvailable(322);

        Flight flight2 = new Flight();
        flight2.setFlightNumber(513928144);
        flight2.setOrigin("Bangkok");
        flight2.setDestination("Singapore");
        flight2.setDepartureTime(LocalDateTime.of(2023, 03, 22, 12,44));
        flight2.setArrivalTime(LocalDateTime.of(2023, 03, 22, 15, 10));
        flight2.setPrice(3000);
        flight2.setSeatAvailable(322);

        Hotel hotel1 = new Hotel();
        hotel1.setHotelID(452123758);
        hotel1.setLocation("Bangkok");
        hotel1.setCheckIn(LocalDateTime.of(2023,03,22,12,00));
        hotel1.setCheckOut(LocalDateTime.of(2023,03,23,12,00));
        hotel1.setPrice(2000);
        hotel1.setGuestAvailable(100);

        Hotel hotel2 = new Hotel();
        hotel2.setHotelID(1237394538);
        hotel2.setLocation("Manila");
        hotel2.setCheckIn(LocalDateTime.of(2023,03,22,12,00));
        hotel2.setCheckOut(LocalDateTime.of(2023,03,23,12,00));
        hotel2.setPrice(5000);
        hotel2.setGuestAvailable(50);

        App app1 = new App();
        app1.addFlight(flight1);
        app1.addFlight(flight2);
        app1.addHotel(hotel1);
        app1.addHotel(hotel2);

        app1.retrieveFlight();
        app1.retrieveHotel();

        app1.searchFlightAndHotel("888888888");
        app1.searchFlightAndHotel("513928144");

        long bookingNumber1 = app1.bookFlight(894125684 , 6);
        long bookingNumber2 = app1.bookHotel(452123758, 2);

        app1.cancelReservation(bookingNumber1);
    }
}
