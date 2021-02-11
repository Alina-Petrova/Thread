/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadCoda;

/**
 *
 * @author tss
 */
public class Consumatore implements Runnable{
    private final String nome;
    private final int intervallo;
    private final Coda q;
    
    private final StringBuilder log = new StringBuilder();

    public Consumatore(String nome, int intervallo, Coda q) {
        this.nome = nome;
        this.intervallo = intervallo;
        this.q = q;
    }

    @Override
    public void run() {
        String s="";
        try {
            while(true) {
               s= q.togli();
               log.append(" ").append(s);
               long p = (long)Math.random()*1000*intervallo;
               Thread.sleep(p);
            }
        }catch (InterruptedException e){
            System.out.println(nome+log);
        }
    }
    
}
