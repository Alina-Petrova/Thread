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
public class Produttore implements Runnable{
    private final String nome;
    private final int intervallo;
    private final ArrayBlockingQueue<String> q;
    private final StringBuilder log = new StringBuilder();
    private final String [] text;

    public Produttore(String nome, int intervallo, ArrayBlockingQueue<String> q, String[] text) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.text = text;
        this.q = q;
    }

    @Override
    public void run() {
        int i=0;
        try {
            while(true) {
                q.add(text[i]);
                log.append(" ").append(text[i]);
                i = (i+1)%text.length;
                long p = (long)Math.random()*1000*intervallo;
                Thread.sleep(p);
            } 
        }catch (InterruptedException e){
            System.out.println(nome+log);
        }
    
    }
       
    
}
