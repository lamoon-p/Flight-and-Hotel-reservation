public class FlightReserve {

    private int flightNumber;
    private int pax;
    private long bookingNumber;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public long getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Override
    public String toString() {
        return "FlightReserve{" +
                "flightNumber=" + flightNumber +
                ", pax=" + pax +
                ", bookingNumber=" + bookingNumber +
                '}';
    }
}
