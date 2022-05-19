package me.whiteship.chapter01.item07.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheTest {

    public static void main(String[] args) {

        Map<CacheKey,Person> maps = new HashMap<>();
        CacheKey cacheKey1 = new CacheKey(1);
        CacheKey cacheKey2 = new CacheKey(2);
        Person person1 = new Person("person1", 25);
        Person person2 = new Person("person2", 24);
        maps.put(cacheKey1,person1);
        maps.put(cacheKey2,person2);

        cacheKey1 = null;
        System.gc(); // 가비지 컬렉팅 과정을 거친다.
        System.out.println(maps.keySet());
    }
}
