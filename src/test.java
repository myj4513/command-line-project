import java.util.*;


public class test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
        list.add(2);
        System.out.println(list.size());

        list.remove(0);
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }

}
