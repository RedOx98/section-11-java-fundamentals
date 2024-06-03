class Brackets{
        private Object lock = "Lock";
    public void generate() throws InterruptedException{
        synchronized(lock){
            for (int i = 1; i < 20; i++) {
                if (i <= 10) {
                    System.out.println("[");
                } else {
                    System.out.println("]");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            Thread.sleep(10);
        }
    }
}

public class Main {

    public static void main(String[] args){
        final Brackets brackets = new Brackets();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    try {
                        brackets.generate();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                long endTime = System.currentTimeMillis();
                System.out.println("Total time required by Thread01: "+(endTime-startTime));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    try {
                        brackets.generate();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                long endTime = System.currentTimeMillis();
                System.out.println("Total time required by Thread02: "+(endTime-startTime));
            }
        }).start();
    }
}
