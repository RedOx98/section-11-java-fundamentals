import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
                queue.put(Main.counter);
                System.out.println("Value added in the queue: "+Main.counter);
                Main.counter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(500);
                queue.take();
                System.out.println("Value removed from  the queue: "+Main.counter);
                Main.counter--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static int counter = 1;
    public static void main(String[] args){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread thread1 = new Thread(new Producer(queue));
        thread1.start();

        Thread thread2 = new Thread(new Consumer(queue));
        thread2.start();
    }
}
