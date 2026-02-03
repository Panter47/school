public class Punto {

    private double x;
    private double y;

    public Punto( double x, double y){
        this.x=x;
        this.y=y;
    }

    public double setX(double x) {
        return x;
    }
    public double setY(double y) {
        return y;
    }

/**
 * restituisce l'attributo x
 * @return (double x)
 */

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public double distanza(Punto p2) {
        return Math.sqrt(Math.pow((p2.getX()-this.x), 2)+ Math.pow((p2.getY()-this.y), 2));
    }

    public boolean equals( Punto p2) {
        
        if(this.x == p2.getX() && this.y == p2.getY())
            return true;
        return false;
    }
    
    public String toString() {
      return "("+this.x+";"+this.y+")";
    }


     /*
    public static void main(String[] args) {
        Punto p1 = new Punto(3, 4);
        Punto p2 = new Punto(7, 8);

        
        
        System.out.println("la distanza tra i due punti è "+p1.distanza(p2));
        System.out.println("i due punti sono uguali? "+ p1.equals(p2));
        System.out.println(p1.toString(p2));
    }*/
}
