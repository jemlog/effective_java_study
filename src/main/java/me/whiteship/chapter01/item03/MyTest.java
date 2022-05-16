package me.whiteship.chapter01.item03;

import me.whiteship.chapter01.item03.staticfactory.Elvis;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class MyTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<UtilityClass> declaredConstructor = UtilityClass.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        UtilityClass utilityClass = declaredConstructor.newInstance();
        System.out.println(utilityClass.getClass());

    }
}
