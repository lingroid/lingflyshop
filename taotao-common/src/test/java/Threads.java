import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingp on 2017-07-14.
 */
public class Threads {
   static volatile List list = new ArrayList();
   public void add(){
       list.add("lingfly");

   }
   public int size(){
       return list.size();
   }

    public static void main(String[] args) {
        final Threads threads = new Threads();
        Thread t1 =new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ;i<10;i++){
                    threads.add();
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (threads.size() == 5) {
                        throw new RuntimeException();
                    }
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }

}
