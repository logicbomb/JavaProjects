import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2){


        DecimalFormat df = new DecimalFormat("0.###");
        df.setRoundingMode(RoundingMode.DOWN);

        double m1 = Double.valueOf(df.format(num1));
        double m2 = Double.valueOf(df.format(num2));

        if (m1 == m2) {
            return true;
        }
else {return false;}

    }
}
