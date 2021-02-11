/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadCodaQ;

import java.util.concurrent.ArrayBlockingQueue;


/**
 *
 * @author tss
 */
public class App {
    public static void main(String[] args) throws InterruptedException{
        ArrayBlockingQueue q = new ArrayBlockingQueue(5);
        String[] text = "She sells seashells by the seashore, The shells she sells are seashells, I'm sure.".split(" ");
        
        Thread p1 = new Thread(new Produttore("produttore1", 1, q, text));
        Thread c1 = new Thread(new Consumatore("consumatore1", 1, q));
        Thread c2 = new Thread(new Consumatore("consumatore2", 2, q));
        
        p1.start();c1.start();c2.start();
        Thread.sleep(1*1000);
        p1.interrupt();c1.interrupt();c2.interrupt();
        System.out.println("coda= "+q.toString());
        
    }
}
