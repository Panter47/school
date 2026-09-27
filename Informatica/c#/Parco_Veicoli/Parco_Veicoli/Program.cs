public class Veicolo
{
    protected string targa;
    protected string marca;
    protected string modello;
    protected double chilometriPercorsi;

    public Veicolo(string targa, string marca, string modello, double chilometriPercorsi)
    {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.chilometriPercorsi = chilometriPercorsi;
    }

    public virtual string stampaDettagli()
    {
        return ($"la marca del veicolo è {marca}, modello {modello}, targa {targa}, ed ha percorso {chilometriPercorsi} km");
    }

    public virtual double calcolaCostoManutenzione(double costo)
    {
        return costo * chilometriPercorsi;
    }
}

public class Auto : Veicolo
{
    int numeroPorte;

    public Auto(string targa, string marca, string modello, double chilometriPercorsi, int numeroPorte) : base(targa, marca, modello, chilometriPercorsi)
    {
        this.numeroPorte = numeroPorte;
    }

    public override string stampaDettagli()
    {
        return base.stampaDettagli() + $", numero di porte {numeroPorte}";
    }

    public override double calcolaCostoManutenzione(double costo)
    {
        return base.calcolaCostoManutenzione(0.05) + 100;
    }
}

public class Camion : Veicolo
{
    double capacitaCarico;

    public Camion(string targa, string marca, string modello, double chilometriPercorsi, double capacitaCarico) : base(targa, marca, modello, chilometriPercorsi)
    {
        this.capacitaCarico = capacitaCarico;
    }

    public override string stampaDettagli()
    {
        return base.stampaDettagli() + $", la capacità di carico è {capacitaCarico} tonnellate";
    }

    public override double calcolaCostoManutenzione(double costo)
    {
        return base.calcolaCostoManutenzione(0.15) + (50 * capacitaCarico);
    }
}

public class Flotta
{
    List<Veicolo> flotta;

    public Flotta(List<Veicolo> flotta)
    {
        this.flotta = flotta;
    }

    public void aggiungiVeicolo(Veicolo veicolo)
    {
        flotta.Add(veicolo);
        Console.WriteLine("veicolo aggiunto");
    }

    public void visualizzaFlotta()
    {
        foreach (Veicolo ve in flotta)
        {
            Console.WriteLine(ve.stampaDettagli());
        }
    }

    public double calcolaCostoTotaleManutenzione()
    {
        double tot = 0;
        foreach (Veicolo ve in flotta)
        {
            tot += ve.calcolaCostoManutenzione(0.05);
        }
        return tot;
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        Flotta flotta = new Flotta(new List<Veicolo>());

        Auto auto = new Auto("AB123CD", "Fiat", "Panda", 15000, 5);
        flotta.aggiungiVeicolo(auto);

        Camion camion = new Camion("EF456GH", "Iveco", "Daily", 80000, 8.5);
        flotta.aggiungiVeicolo(camion);

        Console.WriteLine();

        Console.WriteLine("--- Dettagli flotta ---");
        flotta.visualizzaFlotta();

        Console.WriteLine();

        double costoTotale = flotta.calcolaCostoTotaleManutenzione();
        Console.WriteLine($"Costo totale di manutenzione della flotta: {costoTotale}€");
    }
}