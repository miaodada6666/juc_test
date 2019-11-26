public class TestVolatile{
    //volatile只能保证修改可见性 不能保证原子性和互斥性
    public static void main(String[] args){
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while(true){
            if(td.isFlag()){
                System.out.println("########");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{
    private volatile boolean flag = false;

    public void run(){
        try{
            // 该线程 sleep(200), 导致了程序无法执行成功
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag="+isFlag());
    }

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

}
