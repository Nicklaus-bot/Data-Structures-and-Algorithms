import java.util.*;
public class QueueBasic{
    public static void main(String[]args) throws Exception{
        Queue<Integer> q = new ArrayDeque<>();

        q.add(10);
        System.out.println(q);

        q.add(20);
        System.out.println(q);

        q.add(30);
        System.out.println(q);

        System.out.println(q.peek());
        System.out.println(q);

        System.out.println(q.remove());
        System.out.println(q);

        q.add(50);
        System.out.println(q);

        q.remove();
        q.remove();
        System.out.println(q);
    }
}