public class Main {
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static void main(String[] args) throws InterruptedException{

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter1++;
                }
            }
        });
        thread1.start();

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter2++;
                }
            }
        });
        thread2.start();


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    thread2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Counter1: "+ counter1);
                System.out.println("Counter2: "+ counter2);
            }
        });
        thread3.start();

        System.out.println("Main thread!!!! "+ Thread.currentThread().getName());
    }
}
