import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.reverse();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));


    }


}
