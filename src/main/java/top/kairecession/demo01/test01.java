package top.kairecession.demo01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test01 {
    public test01() {
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        division division = new division();
        Class<division> divisionClass = division.class;
        Field[] declaredFields = divisionClass.getDeclaredFields();
        Method[] methods = divisionClass.getMethods();
        Field[] var5 = declaredFields;
        int var6 = declaredFields.length;

        int var7;
        for(var7 = 0; var7 < var6; ++var7) {
            Field declaredField = var5[var7];
            declaredField.setAccessible(true);
            if ("name".equals(declaredField.getName())) {
                declaredField.set(division, "haojiahuo");
            }

            System.out.println(declaredField.get(division));
        }

        Method[] var10 = methods;
        var6 = methods.length;

        for(var7 = 0; var7 < var6; ++var7) {
            Method method = var10[var7];
            if ("run2".equals(method.getName())) {
                Object invoke = method.invoke(division, 3);
                System.out.println(invoke);
            }
        }

    }
}