package sql.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sql.SqlApplication;

import javax.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SqlApplication.class)
public class SqlOrderByTest {
    @Resource
    private SqlOrderBy sqlOrderBy;

    @Test
    public void getAllUser() {
        /*List<String> cityList = new ArrayList<String>();
        cityList.add("yangwtest");
        cityList.add("testyangw");
        List<CityUser> tmp = sqlOrderBy.getAllUser("10e47687c11435ce");
        long start = System.currentTimeMillis();
        List<CityUser> list = sqlOrderBy.getAllUser("yangwtest");
        long end1 = System.currentTimeMillis();
        List<CityUser> listTwo = sqlOrderBy.getAllUser(cityList);
        long end2 = System.currentTimeMillis();
        List<SimpleCityUser> listS1 = sqlOrderBy.getSimple("yangwtest");
        List<SimpleCityUser> listS2 = sqlOrderBy.getSimple("testyangw");
        long end3 = System.currentTimeMillis();
        listS1.addAll(listS2);
        listS1.sort(new Comparator<SimpleCityUser>() {
            public int compare(SimpleCityUser o1, SimpleCityUser o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        long end4 = System.currentTimeMillis();
        List<CityUser> finalResult =
                sqlOrderBy.getDataByIds(listS1.subList(1,1000).stream().map(SimpleCityUser::getId).collect(Collectors.toList()));
        long end5 = System.currentTimeMillis();
        System.out.println(end1 - start);
        System.out.println(end2 - end1);
        System.out.println(end3 - end2);
        System.out.println(end4 - end3);
        System.out.println(end5 - end4);*/
    }

    @Test
    public void test() {
        int[] param = {2,3,1,0,2};
        System.out.println(findRepeatNumber(param));
    }

    public static int findRepeatNumber(int[] nums) {
        int[] array = new int[nums.length - 1];
        int repeat = -1;
        for (int i = 0; i < nums.length;i++) {
            if (0 != array[nums[i]]) {
                repeat = nums[i];
                break;
            } else {
                array[nums[i]] = nums[i] + 1;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] param = {2,3,1,0,2};
        System.out.println(findRepeatNumber(param));
    }
}