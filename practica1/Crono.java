
package javaapplication1;
import java.util.Random; 
public class Crono {
        public static void main(String[] args) {
            Cronometro cr = new Cronometro(); 
            cr.inicia();
            Random r = new Random (); 
            int min = 1; 
            int max = 100000; 
            
            int vec[] = new int [100000];
            for (int i = 0; i < 100000; i++){
                int ran = r.nextInt((max - min) +1 )+ min ;
                vec[i] = ran; 
            }
            int n = vec.length; 
            for (int i = 0; i < n - 1; i++) {
            // Encuentra el mínimo elemento en la sublista no ordenada
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (vec[j] < vec[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambia el mínimo encontrado con el primer elemento
            int auxiliar = vec[indiceMinimo];
            vec[indiceMinimo] = vec[i];
            vec[i] = auxiliar;
        }
        for (int i= 0; i < vec.length; i++){
           System.out.println(vec[i]); 
        }
        cr.finaliza();
        System.out.print("lapso de tiempo: " + cr.Lapsodetiempo() + "ms");
    }
}

