package web.dao;

import org.apache.ibatis.annotations.Param;
import web.bean.City;
import web.bean.Hotel;

import java.util.Map;

public interface HotalDAO {
    public Hotel getHotelById(int id);

    public City getCityHotel(String cityCode);

    public Hotel getHotelByMap(Map<String,Object> map);

    public void updateHotel(Hotel hotel);

    public void insertHotel(Hotel hotel);

    public void deleteHotel(Integer i);
}
