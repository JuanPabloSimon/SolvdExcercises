import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
public class Practice {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ;

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;

        array.add(num1);
        array.add(num2);

        System.out.println(array);
        int indexFind = array.indexOf(num2);
        array.remove(indexFind);
        System.out.println(array);
    }
}