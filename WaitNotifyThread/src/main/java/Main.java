public class Main {

    public static int balance = 0;
    synchronized public void withdraw(int amount) throws InterruptedException {
        if (balance <= 0){
            System.out.println("Waiting for amount to be updated after withdrawal of $" + amount);
            wait();
        }
        balance -= amount;
        System.out.println("The current balance is $"+ balance);
    }

    public void deposit(int amount){
        synchronized (this){
            System.out.println("We are depositing the amount in the bank of  sum $" + amount);
            balance += amount;
            notify();
        }
    }
    public static void main(String[] args){
        final Main main = new Main();



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("Thread 1");
        thread1.start();





        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                main.deposit(3000);
            }
        });
        thread2.setName("Thread 2");
        thread2.start();
    }
}