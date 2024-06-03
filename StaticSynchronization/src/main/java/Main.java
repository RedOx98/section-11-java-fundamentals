class Brackets{
    synchronized public static void generate(){
            for (int i = 1; i < 20; i++) {
                if (i <= 10) {
                    System.out.println("[");
                } else {
                    System.out.println("]");
                }
            }
            System.out.println();
    }
}

public class Main {

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    Brackets.generate();
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
                    Brackets.generate();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Total time required by Thread01: "+(endTime-startTime));
            }
        }).start();
    }
}
