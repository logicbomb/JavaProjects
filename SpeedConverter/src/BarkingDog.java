public class BarkingDog {
public static boolean shouldWakeUp(boolean barking, int hourOfDay){
    if (hourOfDay > 23 | hourOfDay < 0){
        barking = false;
            }
    else if (hourOfDay > 22 | hourOfDay < 8){
        barking = barking;
    }
    else {
        barking = false;
    }
    return barking;
}
}
