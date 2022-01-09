package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Jdk8Demo {
    public static void main(String[] args) {
//        // 定义一个List集合 
//        long count = Stream.of("a1", "a2", "a3").count();
//        System.out.println(count);
//        Stream.of("a1", "a2", "a3","bb","cc","dd")
//        Stream.of("1", "2", "3","4","5","6","1","1","2")
//                .map(Integer::parseInt)
//                .sorted((o1,o2)->o2-o1)
//                .distinct()
//                .forEach(System.out::println);
//        Integer reduce = Stream.of("1", "3", "3", "4", "5", "1", "7")
//                .map(Integer::parseInt)
//                .reduce(0,Math::max);
//        System.out.println(reduce);
//        Integer arr[] = {1,2,3,5,6,8};
//        IntStream intStream = Stream.of(arr) .mapToInt(Integer::intValue); 
//        intStream.filter(i->i>3) .forEach(System.out::println);


//        1. 第一个队伍只保留姓名长度为3的成员
//        2. 第一个队伍筛选之后只要前3个人
//        3. 第二个队伍只要姓张的成员
//        4. 第二个队伍筛选之后不要前两个人
//        5. 将两个队伍合并为一个队伍
//        6. 根据姓名创建Person对象
//        7. 打印整个队伍的Person信息     

//        List<String> list1 = Arrays.asList("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公"); 
//        List<String> list2 = Arrays.asList("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三"); // 1. 第一个队伍只保留
//
//        Stream<String> stream1 = list1.stream().filter(s -> s.length() == 3).limit(3);
//        Stream<String> stream2 = list2.stream().filter(s -> s.contains("张")).skip(2);
//
//        Stream.concat(stream1,stream2).map(Person::new).forEach(System.out::println);

//        List<String> list = Stream.of("aa", "bb", "cc","aa") .collect(Collectors.toList());
//        System.out.println(list);
//
//        Set<String> set = Stream.of("aa", "bb", "cc", "aa") .collect(Collectors.toSet()); System.out.println(set);
//
//        ArrayList<String> arrayList = Stream.of("aa", "bb", "cc", "aa") //.collect(Collectors.toCollection(() -> new ArrayList<>())); 
//         .collect(Collectors.toCollection(ArrayList::new)); 
//        System.out.println(arrayList); 
//        
//        HashSet<String> hashSet = Stream.of("aa", "bb", "cc", "aa") 
//                .collect(Collectors.toCollection(HashSet::new)); 
//        System.out.println(hashSet);

//        Object[] objects = Stream.of("aa", "bb", "cc", "aa") .toArray();
//        // 返回的数组中的元素是 Object类型 
//        System.out.println(Arrays.toString(objects));
//
//        Stream.of("1", "3", "3", "4", "5", "1", "7")
//                .map(Integer::parseInt)
//                .reduce(0,Math::max);

//        Optional<Person> maxAge = Stream.of( new Person("张三", 18) , new Person("李四", 22) , new Person("张三", 13) , new Person("王五", 15) , new Person("张三", 19) )
//                .collect(Collectors.maxBy((p1, p2) -> p1.getAge() - p2.getAge()));
//                System.out.println(maxAge.get());
//
//        System.out.println(Stream.of(new Person("张三", 18), new Person("李四", 22), new Person("张三", 13), new Person("王五", 15), new Person("张三", 19))
//                .collect(Collectors.minBy((p1, p2) -> p1.getAge() - p2.getAge())));
//
//        Stream.of( new Person("张三", 18) , new Person("李四", 22) , new Person("张三", 13) , new Person("王五", 15) , new Person("张三", 19) )
//                .collect(Collectors.summingInt(Person::getAge));

//        Map<String, List<Person>> map1 = Stream.of( new Person("张三", 18, 175) , new Person("李四", 22, 177) , new Person("张三", 14, 165) , new Person("李四", 15, 166) , new Person("张三", 19, 182) )
//                .collect(Collectors.groupingBy(p->{
//                   return p.getAge()>=18?"成年":"未成年";
//                }));
//        
//        map1.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });

        Map<String, Map<String, List<Person>>> map1 = Stream.of(new Person("张三", 18, 175), new Person("李四", 22, 177), new Person("张三", 14, 165), new Person("李四", 15, 166), new Person("张三", 19, 182))
                .collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(p -> p.getAge() <= 18 ? "成年" : "未成年")));

        map1.forEach((k,v)->{
            System.out.println(k);
            v.forEach((k1,v1)->{
                System.out.println(k1);
                System.out.println(v1);
            });
        });


        List<String> strings = Arrays.asList("1", "3", "3", "4", "5", "1", "7");
        List<Integer> collect = strings.stream().map(s -> {
            int i = Integer.parseInt(s);
            return i;
        }).collect(Collectors.toList());

        System.out.println(collect);


    }
}
