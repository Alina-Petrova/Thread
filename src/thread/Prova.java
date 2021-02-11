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
public class Prova extends Thread{

    public Prova(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            System.out.println(i+" "+getName());
            try {
                Thread.sleep((long)Math.random()*1000);
            }catch(InterruptedException e){
                System.out.println("Finished"+getName());
            }
    }
    }
    
}
