package top.kairecession.demo01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@pro({1, 2, 4})
class division {
    @pro(filedName = "name")
    private String name = "woc";
    private int age = 18;


    public static void main(String[] args) {
        Class<division> divisionClass = division.class;
        pro annotation2 = divisionClass.getAnnotation(pro.class);
        // 一个注解就是一个注解接口的实现对象
        // @top.kairecession.demo01.pro(methodName="none", className="none", filedName="none", value={1, 2, 4})
        System.out.println(annotation2);
        pro annotation = divisionClass.getAnnotation(pro.class);
        Method[] methods = divisionClass.getMethods();

        for(Method method : methods) {
            if (method.isAnnotationPresent(pro.class)) {
                Annotation[] annotations = method.getAnnotations();

                for(Annotation annotation1 : annotations) {
                    // @top.kairecession.demo01.pro(methodName="run", className="none", filedName="none", value={1, 2})
                    System.out.println(annotation1);
                }

                pro annotation1 = method.getAnnotation(pro.class);
                String s = annotation1.methodName();
                // run
                System.out.println(s);
            }
        }

        String s = annotation.className();
        String s1 = annotation.methodName();
        // nonenone
        System.out.println(s + s1);
    }

    @pro(methodName = "run")
    public void run(int i) {
        System.out.println(i);
    }

    public int run2(int i) {
        return i;
    }
}