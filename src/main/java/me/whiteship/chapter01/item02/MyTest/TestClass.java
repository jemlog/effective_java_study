package me.whiteship.chapter01.item02.MyTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClass {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Elvis elvis = declaredConstructor.newInstance();

    }
}
