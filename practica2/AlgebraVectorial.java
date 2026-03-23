package clases; 
public class AlgebraVectorial{ 


    public static class Vector {
        private double x, y, z;
        
        public Vector() {
            this(0, 0, 0);
        }

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Vector(Vector v) {
            this(v.x, v.y, v.z);
        }
        
        public Vector add(Vector v) {
            return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
        }

        public Vector subtract(Vector v) {
            return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
        }

        public double magnitude() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        public double dot(Vector v) {
            return this.x * v.x + this.y * v.y + this.z * v.z;
        }

        public Vector cross(Vector v) {
            return new Vector(
                this.y * v.z - this.z * v.y,
                this.z * v.x - this.x * v.z,
                this.x * v.y - this.y * v.x
            );
        }

        public Vector scalarMultiply(double s) {
            return new Vector(this.x * s, this.y * s, this.z * s);
        }

        @Override
        public String toString() {
            return String.format("(%.2f, %.2f, %.2f)", x, y, z);
        }
    }

    public boolean perpendicular(Vector a, Vector b) {   
        return Math.abs(a.dot(b)) == 0;
    }

    public boolean perpendicular(Vector a, Vector b, String condicion) {
        double magSum = a.add(b).magnitude();
        double magDiff = a.subtract(b).magnitude();       
        return Math.abs(magSum - magDiff) == 0;
    }
 
    public boolean perpendicular(Vector a, Vector b, double[] dummy) {
        double magSumSq = a.add(b).magnitude();
        magSumSq *= magSumSq;
        double sumSq = a.magnitude() * a.magnitude() + b.magnitude() * b.magnitude();        
        return Math.abs(magSumSq - sumSq) == 0;
    }

    public boolean perpendicular(Vector a, Vector b, int flag) {
        double magAB = a.subtract(b).magnitude();
        double magBA = b.subtract(a).magnitude();       
        return Math.abs(magAB - magBA) == 0;
    }

    public String paralela(Vector a, Vector b) {
        Vector cross = a.cross(b);
        if (Math.abs(cross.x) == 0 && Math.abs(cross.y) == 0 && Math.abs(cross.z) == 0)
            return "u x w == 0"; 
        else return "u x w != 0";
            
    }

    public String paralela(Vector a, Vector b, double r) {
        Vector rB = b.scalarMultiply(r);
        if (Math.abs(a.x - rB.x) == 0 &&
               Math.abs(a.y - rB.y) == 0 &&
               Math.abs(a.z - rB.z) == 0) { return "a = rb"; }                   
        else return "a != rb";
    }

    public Vector proyeccion(Vector a, Vector b) {
        double dot = a.dot(b);
        double magBSq = b.magnitude() * b.magnitude();
        if (magBSq == 0) {
            throw new ArithmeticException("No se puede proyectar sobre el vector nulo.");
        }
        double factor = dot / magBSq;
        return b.scalarMultiply(factor);
    }

    public double componente(Vector a, Vector b) {
        double magB = b.magnitude();
        if (magB == 0) {
            throw new ArithmeticException("No se puede calcular componente sobre el vector nulo.");
        }
        return a.dot(b) / magB;
    }

    public static void main(String[] args) {
        Vector u = new Vector(1, 0, 0);
        Vector v = new Vector(0, 1, 0);   
        Vector w = new Vector(2, 0, 0);   
        Vector x = new Vector(1, 1, 0);   

        AlgebraVectorial algebra = new AlgebraVectorial();
        if (algebra.perpendicular(u, v, "mag")) System.out.println ("los vectores " + u + " y " + v + "son ortogonales o perpendiculares"); 
        else System.out.println ("los vectores " + u + " y " + v + "NO son ortogonales o perpendiculares"); 
        
        if (algebra.perpendicular(u, v, 0)) System.out.println ("los vectores " + u + " y " + v + "son mutuamente ortogonales");
        
        if (algebra.perpendicular(u, v)) System.out.println("los vectores " + u + " y " + v + "son ortogonales");
        else System.out.println("los vectores " + u + " y " + v + "NO son ortogonales");
        
       
        
        if (algebra.perpendicular(u, v, new double[0])) System.out.println("los vectores " + u + " y " + v + "son ortogonales" + "|a+b|");
        System.out.println("PARALELOS");
        System.out.println(algebra.paralela(u, w));
        System.out.println("u == 0.5 * w " + algebra.paralela(u, w, 0.5));                
        System.out.println("u == 1 * w? " + algebra.paralela(u, w, 1.0));                 

        System.out.println ("PROYECCION"); 
        Vector proy = algebra.proyeccion(x, u);
        double comp = algebra.componente(x, u);
        System.out.println("Proyeccion ortogonal de " + x + " y " + u + " es: " + proy);
        System.out.println("el componente de " + x + " en la direccion de " + u + " es: " + comp);
    }
}