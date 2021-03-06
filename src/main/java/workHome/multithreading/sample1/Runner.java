package workHome.multithreading.sample1;

import workHome.multithreading.sample2.Resource;
import workHome.multithreading.sample2.ThreadRecourse;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) throws Exception {

        List<Integer> cats = new ArrayList<>();
        cats.add(2);
        Set<String> vae = new LinkedHashSet<>();

        Resource resource = new Resource(); //create obj resource  //synchronized лочить obj
        resource.setI(5);
        ThreadRecourse threadRecourse = new ThreadRecourse();
        threadRecourse.setName("1fst thread");
        threadRecourse.setResource(resource); //1 thread use (resource) obj
        threadRecourse.start();
        ThreadRecourse threadRecourse2 = new ThreadRecourse();
        threadRecourse2.setName("2fst thread");
        threadRecourse2.setResource(resource); //2 thread use (resource) obj

        threadRecourse2.start();
        threadRecourse.join(); // join 1thread vs 2thread
        threadRecourse2.join();
        System.out.println(resource.getI());


        PrinterThread first = new PrinterThread("Thread first ");
        Thread.sleep(2000);
        //first.run();



        PrinterThread second = new PrinterThread("Thread second ");
        second.setPriority(1);
        second.start();
        Thread.sleep(2000);
        //second.run();





        PrinterThread fact = new PrinterThread("Thread factorial ");
        fact.start();
        System.out.printf("Factorial %s\n", +fact.getResultFactorial(5) + Thread.currentThread().getName());
        Thread.sleep(2000);
        //second.run();


        Runnable myRunnable = new RunnableTest("Thread myRunnable ");
        Thread thread = new Thread(myRunnable);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread.join();
        Thread.sleep(2000);

        Runnable myRunnableTwo = new RunnableTest("Thread myRunnableTwo ");
        Thread threadTwo = new Thread(myRunnableTwo);
        threadTwo.join();
        threadTwo.start();
        Thread.yield();
        Thread.sleep(2000);


        new RunnableTest("Thread Runnable static ").run();
        Thread.sleep(3000);// выполняет метод run последовательно без использования Thread


        new RunnableTest.MyThread("Thread static MyThreadOne ").start();
        Thread.sleep(2000);


        new RunnableTest.MyThread("Thread static MyThreadTwo ").start();
        Thread.yield(); //дает вероятность что поток  выполнится раньше
        Thread.sleep(2000);


    }

}

class RunnableTest implements java.lang.Runnable {
    private String name;



    public RunnableTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++)
        {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("I'm %s\n", name + Thread.currentThread().getName());
        }
    }

    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            Thread.yield();
          synchronized (this) { for (int i = 0; i < 3; i++) {
                System.out.printf("I'm %s\n", name + Thread.currentThread().getName() + " i = " + i);}
            }
        }
    }
}







