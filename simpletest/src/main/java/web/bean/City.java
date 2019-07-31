package web.bean;

import java.util.List;

public class City {
    private String cityCode;
    private String cityName;
    private List<Hotel> hotelList;

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @Override
    public String toString() {
        return "City [cityCode=" + cityCode + ", cityName=" + cityName + "]" + hotelList.toString();
    }
}
