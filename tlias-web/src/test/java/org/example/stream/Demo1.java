package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张小四");

        // 用 stream 流的方式找 list 集合中所有姓张且名字为三个字符的元素
        List<String> newarr = list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).collect(Collectors.toList());
        System.out.println(newarr);

        List<Double> pl = new ArrayList<>();
        pl.add(6.9);
        pl.add(5.1);
        pl.add(4.5);
        pl.add(3.9);
        pl.add(2.9);
        pl.add(5.7);
        // 2. 用 stream 流的方式对 pl 集合从大到小排序, 在最后输出
        pl.stream().sorted((p1, p2) -> -p1.compareTo(p2)).forEach(System.out::println);
        // 2. 用 stream 流的方式对 pl 集合从小到大排序, 在最后输出
        pl.stream().sorted((p1, p2) -> p1.compareTo(p2)).forEach(System.out::println);

        List<Teacher> t = new ArrayList<>();
        t.add(new Teacher("张三", 18, "男", "语文", 5000));
        t.add(new Teacher("李四", 26, "男", "英语", 7000));
        t.add(new Teacher("王五", 37, "女", "数学", 9000));
        t.add(new Teacher("赵六", 48, "男", "科学", 12000));
        t.add(new Teacher("孙七", 19, "女", "地理", 6000));

        // 用 stream 流的方式, 先把工资 >= 6000 的教师筛出来，在按工资降序排序，最后输出
        t.stream().filter(teacher -> teacher.getSalary() >= 6000).sorted((t1, t2) -> -t1.getSalary().compareTo(t2.getSalary())).forEach(System.out::println);
        // 用 stream 流的方式,找出工资最高的员工，赋值到一个变量中
        Teacher maxT = t.stream().max((t1, t2) -> t1.getSalary().compareTo(t2.getSalary())).get();
    }
}