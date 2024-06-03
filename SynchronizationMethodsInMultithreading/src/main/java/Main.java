class Brackets{
//     String bracket1 = "";
//    String bracket2 = "";
    synchronized public void generate(){
        for (int i = 1; i < 20 ; i++) {
            if(i <= 10){
                System.out.println("[");
            }else{
                System.out.println("]");
            }
        }
        System.out.println();
    }
}

public class Main {

    public static void main(String[] args){
        final Brackets brackets = new Brackets();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    brackets.generate();

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    brackets.generate();

                }
            }
        }).start();
    }
}
