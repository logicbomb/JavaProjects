

public class Activity {


    public static void main(String[] args){
        int input = 50;
        int counter=0;
        int sum = 0;
        for(int i = 0; i <=1000; i++){

            if (input%3==0 && input%5==0){
                counter++;
                System.out.println("The numbers are: " + input);
                sum=+input;
                if (counter==5){
                    System.out.println("The sum of five number is: " + sum);
                    break;

                }
                input=+1;
            }
        }


    }
}

