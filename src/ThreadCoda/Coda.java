/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadCoda;

import java.util.LinkedList;

/**
 *
 * @author tss
 */
public class Coda {
    private final int capacita;
    private final LinkedList<String> coda;
    private int nProd=0, nCons=0;

    public Coda(int capacita) {
        this.capacita = capacita;
        this.coda = new LinkedList<>();
    }

    public int getCapacita() {
        return capacita;
    }
    
    
    public synchronized void aggiungi(String s) throws InterruptedException {
        while(coda.size()==capacita) {
            nProd++;
            wait();
        }
        coda.add(s);
        notifyAll();            
    }
    public synchronized String togli() throws InterruptedException {
        while(coda.isEmpty()) {
            nCons++;
            wait();
        }
        String s = coda.remove();
        notifyAll();
        return s;
    }

    @Override
    public String toString(){
        return String.format("Numero attese produttori %d , numero attese consumatori %d",nProd, nCons);
    }
    
}
