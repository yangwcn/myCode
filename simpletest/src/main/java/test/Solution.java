package test;

import java.util.*;

public class Solution {
    private static List<Integer> sSorted = new LinkedList<>();

    public static void addElement(int e) {
        for(int i = 0; i < sSorted.size(); i++) {
            if(e < sSorted.get(i)) {
                sSorted.add(i,e);
                return;
            }
        }
        sSorted.add(sSorted.size(),e);
    }

    public static void main(String[] args) {
        /*Map<String,String> map = new HashMap<>();

        for(int i = 0; i < 100; i++) {
            map.put(i + "", "" + i);
        }

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String,String> entry = iterator.next();
            iterator.remove();
        }*/
        /*String s1 = "spring";
        String s2 = new String("spring");
        String s6 = new String("spring");
        String s3 = "spring";
        String s4 = "sp" + "ring";
        char[] s5 = {'s','p','r','i','n','g'};
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
        System.out.println(s2 == s6);
        System.out.println(s1 == s2.intern());
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s5));

        String d = "BEA";
        System.out.println(d.hashCode());
        change(d);
        System.out.println(d);

        String s = "abs";
        String ss= "asb";
        char[] sc = s.toCharArray();
        char[] ssc = ss.toCharArray();
        Arrays.sort(sc);Arrays.sort(ssc);
        System.out.println(Arrays.equals(ssc,sc));

        System.out.println(13 & 17);*/
        time(1000000000L);
        time2(1000000000L);
    }

    public static void time(Long c) {
        Long start = System.currentTimeMillis();
        for(Long i = 0L; i < c; i++) {

        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void time2(Long c) {
        Long start = System.currentTimeMillis();
        for(Long i = 0L; i < c;++i) {

        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void change(String s) {
        System.out.println(s.hashCode());
        s = s.replace("A","E");
        System.out.println(s.hashCode());
        s.toLowerCase();
    }

    public static void exchange(int x) {
        x = 2;
    }
    Queue queue = new LinkedList();

    /**
     * 判断一个输入是否为质数
     * @param number
     * @return
     */
    public static boolean isZhi(int number) {
        boolean isZ = true;
        if(number < 2) {
            return false;
        }
        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return isZ;
    }

    /**
     * 求1到number之间所有质数的和
     * @param number
     * @return
     */
    public static int sumZhi(int number) {
        if(number < 2) {
            System.out.println("输入有误");
            return 0;
        }
        int sum = 0;
        for(int i = 1; i <= number;i++) {
            if(isZhi(i)){
                sum += i;
            }
        }
        return sum;
    }
}
