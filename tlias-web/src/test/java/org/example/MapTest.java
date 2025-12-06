package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        /*
            map.put(K key,V value)                    添加元素
            map.remove(Object key)                    根据键删除键值对元素
            map.clear()                               移除所有的键值对元素
            boolean containsKey(Object key)           判断集合是否包含指定的键
            boolean containsValue(Object value)       判断集合是否包含指定的值
            boolean isEmpty()                         判断集合是否为空
            int size()                                集合的长度，也就是集合中键值对的个数
        */

        // 1. 创建一个HashMap对象
        Map<String, String> map = new HashMap<>(); // ctrl + alt + l 格式化代码

        // 2. 添加键值对
        // 添加键值对时，如果键已经存在，则更新对应的值，会把被覆盖的值返回
        map.put("name", "张三");
        map.put("age", "18");
        map.put("sex", "男");
        map.put("phone", "12345678901");
        map.put("age", "22");

        // 3. 删除键值对
        map.remove("age");

        // 4. 判断集合是否包含指定的键或值
        boolean containsKey = map.containsKey("name");
        boolean containsValue = map.containsValue("12345678901");

        System.out.println(map);

        // 5. map 的遍历
        // 5.1 使用 keySet() 遍历集合中的所有键, 并遍历
        Set<String> keys = map.keySet();
        for (String key : keys) System.out.println(key + ":" + map.get(key));

        // 5.2 使用 keySet() 遍历集合中的所有键, 并通过 foreach 遍历
        map.keySet().forEach(key -> {
            System.out.println(key + ":" + map.get(key));
        });

        // 5.3 使用 entrySet() 遍历集合中的所有键值对元素
        Set<Map.Entry<String, String>> entries = map.entrySet(); // ctrl + alt + v 自动生成左边
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 5.4 使用 entrySet() 遍历集合中的所有键值对元素, 并通过 foreach 遍历
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });

        // 5.5 用 foreach 遍历 map
        map.forEach((key, val) -> {
            System.out.println(key + "=" + val);
        });
    }
}
