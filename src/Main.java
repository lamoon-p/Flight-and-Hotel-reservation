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
    }
}
