
package clases;

public class MiPunto {
    private double x;
    private double y;

    // Constructor
    public double getX(){
       return this.x; 
    }
    public double getY(){
       return this.y; 
    }
    
    public MiPunto(){
        this.x = 0; 
        this.y = 0; 
    }
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distancia(MiPunto otro) {
        double dx = this.x - otro.getX();
        double dy = this.y - otro.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
     public double distancia(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public static void main(String[] args) {
         MiPunto p1 = new MiPunto(3, 5); 
         MiPunto p2 = new MiPunto(4, 6); 
         System.out.println("punto p1 con coordenadas: " + "(" + p1.getX() + "," + p1.getY() + ")");
         System.out.println(p1.distancia(p2));
         System.out.print(p1.distancia(3.3, 6.4));
         
      }
}

