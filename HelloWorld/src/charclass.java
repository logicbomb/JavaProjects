
public class charclass {
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
    char myChar = 'd';
    char myUchar = '\u0044';
    System.out.println(myChar + " " + myUchar);



            // method to return LCM of two numbers

            // Driver method

                int a = 20, b = 15;
                System.out.println("LCM of " + a +
                        " and " + b +
                        " is " + lcm(a, b));

        }
}
