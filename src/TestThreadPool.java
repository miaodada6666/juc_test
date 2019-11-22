import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool{
    public static void main(String[] args){
        // 1. 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        ThreadPoolDemo tpd = new ThreadPoolDemo();

        // 2. 为线程池中线程分配任务
        //    submit(Callable<T> task)
        //    submit(Runnable task)

        //40为等待放入线程池中的任务的数量大于等于5结果都一样
        for(int i=0; i<40; i++){
            pool.submit(tpd);
        }

        // 3. 当线程池中的某一个线程执行结束后，关闭线程池
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable{

    private int i=0;

    public void run(){
        while(i <= 100){
            System.out.println(Thread.currentThread().getName()+" : "+ i++);
        }
    }
}