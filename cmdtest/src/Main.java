import java.util.Arrays;

public class Main implements Comparable{
    public static void calroman(String roman){
        String[] romanO = {"I", "V", "X", "L", "C", "D", "M"};
        int firstL = Arrays.binarySearch(romanO, roman.substring(0,1));
        int secondL = Arrays.binarySearch(romanO, roman.substring(1,2));


        System.out.println(firstL + "    " + secondL);
    }

    public static void main(String[] args) {

        calroman("IV");
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        System.out.println(Arrays.binarySearch(roman, "V"));

//        String hello = "DD";
//        //String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
//        String roman2 = "IVXLCDM";
//        int [] val = {1, 5, 10, 50, 100, 500, 1000};
//        String[] holdTemp = hello.split("");
//        int result = 0;
//        if(hello.length()>1) {
//            for (int i = 0; i <= holdTemp.length - 1; i++) {
//                int tempIndex = roman2.indexOf(holdTemp[i]);
//                int tempIndex2 = roman2.indexOf(holdTemp[i + 1]);
//                if (tempIndex >= tempIndex2) {
//                    //  System.out.println(holdTemp.length +  " and " + i);
//                    if ((i + 1) == holdTemp.length - 1) {
//
//                        result = result + val[tempIndex] + val[tempIndex2];
//                        i = i +2;
//                    } else {
//                        result = result + val[tempIndex];
//                    }
//                }
//                if (tempIndex < tempIndex2) {
//                    if ((i + 1 + 1) == holdTemp.length - 1) {
//                        int tempIndex3 = roman2.indexOf(holdTemp[i + 2]);
//                        result = result + (val[tempIndex2] - val[tempIndex]) + val[tempIndex3];
//                        i += 2;
//                    } else {
//                        result = result + (val[tempIndex2] - val[tempIndex]);
//                        i += 2;
//                    }
//
//
//                }
//
//                System.out.println(result);
//            }
//        }
//        else {
//            result = val[(roman2.indexOf(hello))];
//        }
//        System.out.println(result);
//

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
