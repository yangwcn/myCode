package web.bean;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private int price;
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    /*public Hotel(int hotelId, String hotelName, String hotelAddress, int price) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.price = price;
    }

    public Hotel(int hotelId, String hotelName, String hotelAddress, int price, City city) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.price = price;
        this.city = city;
    }*/

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress + ", price="
                + price + "]";
    }
}
