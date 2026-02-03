public class Rettangolo {
    private double altezza;
    private double base;
    private Punto centro;


    public Rettangolo(double base, double altezza, Punto centro) {
        this.base=base;
        this.altezza=altezza;
        this.centro=centro;
    }

    public double getBase() {
        return base;
    }

    public double getAltezza() {
        return altezza;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setBase(double base) {
        this.base=base;
    }

    public void setAltezza(double altezza) {
        this.altezza=altezza;
    }

    public void setCentro(Punto centro) {
        this.centro=centro;
    }
    
    public Punto getVerticeA() {
        return new Punto(centro.getX()-(base/2),centro.getY()-(altezza/2));
    }

    public Punto getVerticeB() {
        return new Punto(centro.getX()+(base/2),centro.getY()-(altezza/2));
    }

    public Punto getVerticeC() {
        return new Punto(centro.getX()+(base/2),centro.getY()+(altezza/2));
    }

    public Punto getVerticeD() {
        return new Punto(centro.getX()-(base/2),centro.getY()+(altezza/2));
    }

    public String appartieneRettangolo(Punto point) {
        if((point.getX() >= this.getVerticeA().getX() && point.getX() <= this.getVerticeB().getX())  && (point.getY() <= this.getVerticeD().getY() && point.getY() >= this.getVerticeA().getY()))
            return "il punto (" + point.getX() +";" + point.getY() +") appartiene al rettangolo";
        return "il punto (" + point.getX() +";" + point.getY() +") non appartiene al rettangolo";
    }

    public String origine(Punto verticeA, Punto verticeB, Punto verticeC, Punto verticeD) {
        
        Punto origin = new Punto(0,0);

        if(origin.distanza(verticeA) < origin.distanza(verticeB) && origin.distanza(verticeA) < origin.distanza(verticeC) && origin.distanza(verticeA) < origin.distanza(verticeD) )
            return "il vertice di posizione (" + verticeA.getX() + ";" + verticeA.getY() + ") è quello più vicino all'origine";
        else if(origin.distanza(verticeB) < origin.distanza(verticeA) && origin.distanza(verticeB) < origin.distanza(verticeC) && origin.distanza(verticeB) < origin.distanza(verticeD))
            return "il vertice di posizione (" + verticeB.getX() + ";" + verticeB.getY() + ") è quello più vicino all'origine";  
        else if(origin.distanza(verticeC) < origin.distanza(verticeA) && origin.distanza(verticeC) < origin.distanza(verticeB) && origin.distanza(verticeC) < origin.distanza(verticeD))
            return "il vertice di posizione (" + verticeC.getX() + ";" + verticeC.getY() + ") è quello più vicino all'origine";
        return "il vertice di posizione (" + verticeD.getX() + ";" + verticeD.getY() + ") è quello più vicino all'origine";
    }

    public String toString() {
        return String.format("-------------\nCentro: %.2f, %.2f\nBase: %.2f\nAltezza: %.2f\nVertice A: %.2f, %.2f\nVertice B: %.2f, %.2f\nVertice C: %.2f, %.2f\nVertice D: %.2f, %.2f\n-------------", 
            centro.getX(), centro.getY(), base, altezza, 
            getVerticeA().getX(), getVerticeA().getY(), 
            getVerticeB().getX(), getVerticeB().getY(),
            getVerticeC().getX(), getVerticeC().getY(),
            getVerticeD().getX(), getVerticeD().getY());
    }



    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo(10, 5, new Punto(5, 7));

        System.out.println(r1.toString());
        System.out.println(r1.origine(r1.getVerticeA(), r1.getVerticeB(), r1.getVerticeC(), r1.getVerticeD()));
        System.out.println(r1.appartieneRettangolo(new Punto(10, 7)));
        System.out.println(r1.appartieneRettangolo(new Punto(11, 7)));

    }

}
