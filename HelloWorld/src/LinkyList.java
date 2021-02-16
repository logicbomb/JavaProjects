import java.util.Iterator;
import java.util.LinkedList;

public class LinkyList {

    public static void main(String[] args) {
        LinkedList<Integer> linky = new LinkedList<Integer>();
        LinkedList<Integer> linky2 = new LinkedList<Integer>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        int[] l1 = {5, 4, 3};
        int[] l2 = {5, 6, 4};

        for (int i = 0; i < l1.length; i++)
        {
        linky.add(l1[i]);
        }
        for (int j = 0; j < l2.length; j++)
        {
            linky2.add(l2[j]);
        }
 int ii = 0;
        int curr = 0;
        while (linky != null && ii < linky.size())
 {

   System.out.println(linky.get(ii));
     ii++;
 }
        for (int i = linky.size()-1; i >= 0 ; i--) {
            if ((linky.get(i) + linky2.get(i))< 10) {
              output.add(linky.get(i) + linky2.get(i));
                System.out.println("Result is: " + linky.get(i) + " and " + linky2.get(i)  + " is = " + (linky.get(i) + linky2.get(i)));
            }
            else {
                //output.add(Math.addExact(linky.get(i), linky2.get(i)));
            }
        }

        System.out.println(output);

        Iterator round = output.listIterator();
        while (round.hasNext()) {
            System.out.print(round.next());
        }


    }
}
