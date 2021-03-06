package synchronized_program;

public class synchronizedTest_static implements Runnable {
    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public static synchronized void increase(){
        i++;
    }
    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new synchronizedTest_static());
        Thread t2 = new Thread(new synchronizedTest_static());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
