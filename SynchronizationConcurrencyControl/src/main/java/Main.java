import java.util.Random;

import static java.lang.Thread.sleep;



public class Main {
    public static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100000 ; i++) {
                    Main.counter++;
                }
                System.out.println("The loop in thread1 is over ");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100000 ; i++) {
                    Main.counter++;
                }
                System.out.println("The loop in thread2 is over");
            }
        }).start();

        Thread.sleep(200);
        System.out.println("counter: "+counter);
//        long endTime = System.currentTimeMillis();  
    }
}
