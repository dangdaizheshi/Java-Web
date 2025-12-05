package org.example;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // 创建一个HashMap对象
        Map<String, String> map = new HashMap<>(); // ctrl + alt + l 格式化代码
        // 添加键值对
        // 添加键值对时，如果键已经存在，则更新对应的值，会把被覆盖的值返回
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("age", "22");

        map.remove("age");

        boolean contains = map.containsKey("name");

        System.out.println(map);

        map.keySet().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });
    }
}
