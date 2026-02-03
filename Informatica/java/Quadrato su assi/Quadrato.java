public class Quadrato {

    private Punto centro;
    private double lato;
    private double angolo_rotazione;
    
    Quadrato(Punto centro, double lato, double angolo_rotazione) {
        this.centro = centro;
        this.lato = lato;
        this.angolo_rotazione = angolo_rotazione;
    }


    public Punto getCentro () {
        return centro;
    }

    public double getlato() {
        return lato;
    }

    public double getangolo_rotazione() {
        return angolo_rotazione;
    }

    public void setcentro( Punto centro) {
        this.centro = centro;
    }

    public void setlato( double lato) {
        this.lato = lato;
    }

    public void setangolo_rotazione( double angolo_rotazione) {
        this.angolo_rotazione = angolo_rotazione;
    }

    /**
     * calcolo l'area del quadrato
     * @return (double) lato^2
     */

    public double area() {
        return Math.pow(lato, 2);
    }

    /**
     * calcolo il perimetro del quadrato
     * @return (double) lato*4
     */

    public double perimetro(){
        return lato*4;
    }


    /**
     * calcola le coordinate del punto
     * @return
     */

    public Punto getVerticeA () {
        return new Punto(centro.getX() - this.lato/2,centro.getY() + this.lato/2);
    }

     public Punto getVerticeB () {
        return new Punto(centro.getX() + this.lato/2,centro.getY() + this.lato/2);
    }

     public Punto getVerticeC () {
        return new Punto(centro.getX() - this.lato/2,centro.getY() - this.lato/2);
    }


     public Punto getVerticeD () {
        return new Punto(centro.getX() + this.lato/2,centro.getY() - this.lato/2);
    }
    
    public String toString() {
        return String.format("-------------\nCentro: %.2f, %.2f\nAngolo rotazione: %.2f\nLato: %.2f\nVertice A: %.2f, %.2f\nVertice B: %.2f, %.2f\nVertice C: %.2f, %.2f\nVertice D: %.2f, %.2f\n-------------", 
            centro.getX(), centro.getY(), angolo_rotazione, lato, 
            getVerticeA().getX(), getVerticeA().getY(), 
            getVerticeB().getX(), getVerticeB().getY(),
            getVerticeC().getX(), getVerticeC().getY(),
            getVerticeD().getX(), getVerticeD().getY());
    }
    
    public static void main(String[] args) {
        Quadrato q1 = new Quadrato (new Punto (4,8), 2,0);

        System.out.println(q1.toString());

    }
}