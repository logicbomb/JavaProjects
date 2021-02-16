public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int mb = kiloBytes / 1024;
        int rKb = kiloBytes % 1024;
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");

        } else {
            System.out.println(kiloBytes + " KB = " + mb + "MB and " + rKb + " KB");
        }
    }
}
