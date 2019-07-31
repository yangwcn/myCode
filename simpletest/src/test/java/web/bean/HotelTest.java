package web.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import web.Service.UserService;
import web.dao.HotalDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class HotelTest {
    @Test
    public void test() {
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext(new ClassPathResource("/config/spring/applicationcontext.xml"));
        /*UserService userService = (UserService)applicationContext.getBean("userService");*/
        HotalDAO hotelDAO = (HotalDAO)applicationContext.getBean("hotalDAO");
        Map<String,Object> map = new HashMap<>();
        map.put("hotelId",1001);
        map.put("price",100);
        //Hotel hotel = hotelDAO.getHotelByMap(map);
        Hotel hotel = hotelDAO.getHotelById(1001);
        System.out.println(hotel.toString());
        assert(true);
    }

    @Test
    public void testList() {
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext(new ClassPathResource("/config/spring/applicationcontext.xml"));
        /*UserService userService = (UserService)applicationContext.getBean("userService");*/
        HotalDAO hotelDAO = (HotalDAO)applicationContext.getBean("hotalDAO");
        //Hotel hotel = hotelDAO.getHotelByMap(map);
        City city = hotelDAO.getCityHotel("1001");
        System.out.println(city.toString());
        assert(true);
        Thread.dumpStack();
       /* Callable;
        Future;*/
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        HashMap<String,String> mpa = new HashMap<>();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() {
                return null;
            }
        });
        executorService.shutdown();
    }

    @Test
    public void testADD() {
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext(new ClassPathResource("/config/spring/applicationcontext.xml"));
        /*UserService userService = (UserService)applicationContext.getBean("userService");*/
        HotalDAO hotelDAO = (HotalDAO)applicationContext.getBean("hotalDAO");

        Hotel hotel = new Hotel();
        City city = new City();
        city.setCityCode("1001");
        city.setCityName("beijing");
        hotel.setCity(city);
        hotel.setHotelAddress("南京玄武饭店1");
        hotel.setHotelName("鼓楼区中央路193号1");
        hotel.setPrice(190);
        //0, "南京玄武饭店1", "鼓楼区中央路193号1", 997
        hotelDAO.insertHotel(hotel);
        assert(true);
    }

}