
package clases;
public class Vector {
    private double x, y, z;

    // Constructores
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

    // Getters y Setters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    // Norma (longitud)
    public double norma() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    // Normalización (retorna un nuevo vector normalizado)
    public Vector normalizar() {
        double n = norma();
        if (n == 0) return new Vector(this);
        return new Vector(x / n, y / n, z / n);
    }

    // Suma de vectores
    public Vector suma(Vector v) {
        return new Vector(x + v.x, y + v.y, z + v.z);
    }

    // Resta de vectores
    public Vector resta(Vector v) {
        return new Vector(x - v.x, y - v.y, z - v.z);
    }

    // Multiplicación por escalar
    public Vector multiplicarEscalar(double k) {
        return new Vector(x * k, y * k, z * k);
    }

    // División por escalar
    public Vector dividirEscalar(double k) {
        if (k == 0) return new Vector(this);
        return new Vector(x / k, y / k, z / k);
    }

    // Producto escalar (dot)
    public double productoEscalar(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    // Producto vectorial (cross)
    public Vector productoVectorial(Vector v) {
        return new Vector(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x
        );
    }

    // Proyección ortogonal de este vector sobre otro
    public Vector proyeccionSobre(Vector v) {
        double normaV = v.norma();
        if (normaV == 0) return new Vector();
        double factor = productoEscalar(v) / (normaV * normaV);
        return new Vector(v.x * factor, v.y * factor, v.z * factor);
    }

    // Componente (proyección escalar) de este vector sobre otro
    public double componenteEn(Vector v) {
        double n = v.norma();
        if (n == 0) return 0;
        return productoEscalar(v) / n;
    }

    // Verifica si este vector es perpendicular a otro (tolerancia 1e-9)
    public boolean esPerpendicular(Vector v) {
        return Math.abs(productoEscalar(v)) < 1e-9;
    }

    // Comparación (con tolerancia) 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector v = (Vector) obj;
        final double EPS = 1e-9;
        return Math.abs(x - v.x) < EPS &&
               Math.abs(y - v.y) < EPS &&
               Math.abs(z - v.z) < EPS;
    }

    @Override
    public String toString() {
        return String.format("(%.4f, %.4f, %.4f)", x, y, z);
    }
    public static void main(String[] args) {
        Vector a = new Vector(3, 4, 0);
        Vector b = new Vector(1, 0, 0);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);
        System.out.println("Norma de a: " + a.norma());

        Vector suma = a.suma(b);
        System.out.println("a + b = " + suma);

        Vector resta = a.resta(b);
        System.out.println("a - b = " + resta);

        double escalar = 2.5;
        Vector multEsc = a.multiplicarEscalar(escalar);
        System.out.println("a * " + escalar + " = " + multEsc);

        double prodEsc = a.productoEscalar(b);
        System.out.println("Producto escalar a·b = " + prodEsc);

        Vector prodVec = a.productoVectorial(b);
        System.out.println("Producto vectorial a × b = " + prodVec);

        System.out.println("¿a perpendicular a b? " + (a.esPerpendicular(b) ? "Sí" : "No"));

        Vector proy = a.proyeccionSobre(b);
        System.out.println("Proyección de a sobre b = " + proy);
        System.out.println("Componente de a en dirección de b = " + a.componenteEn(b));

        Vector an = a.normalizar();
        System.out.println("Vector a normalizado = " + an);
        System.out.println("Norma del normalizado: " + an.norma());

        Vector c = new Vector(1, 2, 3);
        Vector d = new Vector(4, -5, 2);
        System.out.println("c = " + c + ", d = " + d);
        System.out.println("c·d = " + c.productoEscalar(d) + " => " +
                (c.esPerpendicular(d) ? "son perpendiculares" : "no son perpendiculares"));
    }

}