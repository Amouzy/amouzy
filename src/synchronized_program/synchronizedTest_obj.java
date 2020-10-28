package synchronized_program;

public class synchronizedTest_obj implements Runnable {
    static synchronizedTest_obj obj=new synchronizedTest_obj();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(obj){
            for(int j=0;j<10000;j++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
