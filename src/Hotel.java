import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hotel {

    private int hotelID;
    private String location;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private int price;
    private int guestAvailable;

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuestAvailable() {
        return guestAvailable;
    }

    public void setGuestAvailable(int guestAvailable) {
        this.guestAvailable = guestAvailable;
    }
}
