
package javaapplication1;

public class Cronometro {
    private long inicia; 
    private long finaliza; 
    
    public long getinicia(){
        return inicia; 
    }
    public long getfinaliza(){
        return finaliza; 
    }
    public Cronometro(){
        this.inicia = System.currentTimeMillis(); 
    }
    public void inicia(){
       this.inicia = System.currentTimeMillis(); 
    }
    public void finaliza(){
        this.finaliza = System.currentTimeMillis(); 
    }
    public long Lapsodetiempo(){
        return (this.finaliza - this.inicia); 
    }
}
