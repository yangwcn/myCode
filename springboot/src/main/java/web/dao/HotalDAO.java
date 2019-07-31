package web.dao;

import org.springframework.stereotype.Repository;
import web.bean.City;
import web.bean.Hotel;

import java.util.Map;

@Repository
public interface HotalDAO {
    public Hotel getHotelById(int id);

    public City getCityHotel(String cityCode);

    public Hotel getHotelByMap(Map<String, Object> map);

    public void updateHotel(Hotel hotel);

    public void insertHotel(Hotel hotel);

    public void deleteHotel(Integer i);
}
