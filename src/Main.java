import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {
                while(true){

                    sleep(6000);
                    printThread(threads);
                }
            } catch (InterruptedException e) {
                System.out.println("Exception thrown ");
            }

        };

        Thread statusReporterThread = new Thread(statusReporter);
        statusReporterThread.start();

        while(true) {
            System.out.println("Enter limit for want to check Prime number Count :");
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            if (userInput==0){
                threads.forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("Calculated "+threads.size()+" times\n"+"Now Stopping application");
                statusReporterThread.interrupt();
                break;
            }

            Runnable r = () -> {
                PrimeNumberUtils primeNumberUtils = new PrimeNumberUtils();
                int primeNumberCounts = primeNumberUtils.getPrimeNumberCounts(userInput);
                System.out.println("Count is " + primeNumberCounts);
            };
            //User Thread
            Thread t = new Thread(r);

            threads.add(t);
            t.start();
        }
    }

    public static void printThread(List<Thread> threads){
        System.out.println();
        threads.forEach( thread-> System.out.print(thread.getName()+" is "+thread.getState()+";"));
    }
}
