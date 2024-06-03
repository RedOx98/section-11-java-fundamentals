import java.util.Random;

import static java.lang.Thread.sleep;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Random random = new Random();
                        sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }).start();
        long endTime = System.currentTimeMillis();
        System.out.println("Time it took to  run multiThread is: "+ (endTime - startTime));
    }
}
