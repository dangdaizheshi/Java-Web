package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapPracticeTest {
    public static void main(String[] args) {
        /*
            某个班级80名学生，现在需要组成秋游活动，
            班长提供了四个景点依次是（A、B、C、D），
            每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
        */
        String[] arr = {"A", "B", "C", "D"};
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if(map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        map.forEach((key, val) -> System.out.println(key + ":" + val));
    }
}