/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author tss
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
       new Worker("worker1").start();
       new Worker("worker2").start();
       new Prova("Prova").start();
       Runnable r = new ProvaRunnable();
       Thread t = new Thread(r);
       t.start();
       Thread.sleep(10 * 1000);
        t.interrupt();
    }
    
    public static class Worker extends Thread {

        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println(i+" "+getName());
                try{
                    sleep((long)Math.random()*1000);
                }catch(InterruptedException ex){
                    System.out.println("Fatto"+getName());
                }
            }
        }
    }    
}
