import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        while(true) {
            System.out.println("Enter limit for want to check Prime number Count :");
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            if (userInput==0)
                break;
            Runnable r = new Runnable(){

                @Override
                public void run() {
                    PrimeNumberUtils primeNumberUtils = new PrimeNumberUtils();
                    int primeNumberCounts = primeNumberUtils.getPrimeNumberCounts(userInput);
                    System.out.println("Count is " + primeNumberCounts);
                }
            };
            //User Thread
            Thread t = new Thread(r);
            //This makes thread as Dameon30
            t.setDaemon(true);
            t.start();
        }
    }
}
