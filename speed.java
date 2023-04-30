public class speed extends Thread{
    int interval = 1000;
    public void run(){
        while(interval>250){
            synchronized (this){
                try {
                    interval -=10;
                    wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
