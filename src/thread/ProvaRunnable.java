/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class ProvaRunnable implements Runnable{
    

    public ProvaRunnable() {
        
    }

    @Override
    public void run() {
        int i=1;
        while(true) {
            System.out.println(i+" "+getClass().getName());
            try {
                Thread.sleep((long)Math.random()*1000);
            }catch(InterruptedException e) {
                System.out.println("Interrotto!"+getClass().getName());
            }
            try {
                Thread.currentThread().sleep(10 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProvaRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread.currentThread().interrupt();
        }
    }
    
}
