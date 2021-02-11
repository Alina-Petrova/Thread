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
public class Consumatore implements Runnable{
    private final String nome;
    private final int intervallo;
    private final ArrayBlockingQueue<String> q;
    
    private final StringBuilder log = new StringBuilder();

    public Consumatore(String nome, int intervallo, ArrayBlockingQueue<String> q) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.q = q;
    }

    @Override
    public void run() {
        String s="";
        try {
            while(true) {
               s= q.take();
               log.append(" ").append(s);
               long p = (long)Math.random()*1000*intervallo;
               Thread.sleep(p);
            }
        }catch (InterruptedException e){
            System.out.println(nome+log);
        }
    }
    
}
