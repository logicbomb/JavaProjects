public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        if(kilometersPerHour < 0) {
            return -1;
        }

        return Math.round(kilometersPerHour / 1.609);
    }

    public static void printConversion(double kilometersPerhour){
        if (kilometersPerhour<0){
            System.out.println("Invalid Value");
        }
        else {
            long milesPerHour = toMilesPerHour(kilometersPerhour);
            System.out.println(kilometersPerhour +
                    " km/h = " + milesPerHour + " mi/h");
        }

    }

}
