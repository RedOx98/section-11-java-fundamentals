public class Main {

    public static int balance = 0;
    synchronized public void withdraw(int amount)  {
        if (balance <= 0){
            System.out.println("Waiting for amount to be updated after withdrawal of $" + amount);
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Withdrawal interrupted.");
                return;
            }
        }
        if((balance - amount) < 0) {
            System.out.println("Balance too low for withdrawal "+ balance);
            System.out.println("Withdrawal incomplete.");
            return;
        }
        balance -= amount;
        System.out.println("The current balance is $"+ balance);
    }

    public boolean deposit(int amount){
        synchronized (this){
            if (amount > 0) {
                System.out.println("We are depositing the amount in the bank of  sum $" + amount);
                balance += amount;
                notify();
                return true;
            } else {
                System.out.println("Invalid Amount...");
                return false;
            }
        }
    }
    public static void main(String[] args){
        final Main main = new Main();



        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                    main.withdraw(1000);

            }
        });
        thread1.setName("Thread 1");
        thread1.start();





        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (main.deposit(500)){
                    System.out.println("Txn completed");
                } else {
                    thread1.interrupt();
                };
            }
        });
        thread2.setName("Thread 2");
        thread2.start();
    }
}