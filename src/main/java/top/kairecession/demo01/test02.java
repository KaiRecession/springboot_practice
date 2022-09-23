package top.kairecession.demo01;

import java.util.*;

public class test02 {
    int[] s;


    public test02(int[] s) {
        this.s = s;
    }

    private void modify(int[] s) {
        this.s = s;
    }

    public static int test22(int f) {
        try {

            return f;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(43254654654L);
        }
        return 24;
    }

    public static void main(String[] args) {
        Deque<Integer> test = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        final Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            int pre = iterator.next();
            if (test.size() == 0)
                test.add(iterator.next());
            else {
                if (pre > test.getFirst())
                    test.addLast(pre);
                else {
                    test.addFirst(pre);
                }
            }
            System.out.println(test);
            System.out.println((List)test);
        }


    }
}
