using System.Reflection.Metadata.Ecma335;

namespace WinFormsLibraryBiblioteca
{
    public class Risorsa
    {
        string codice;
        string titolo;
        string autore;
        int giorniPrestito;

        public Risorsa(string codice, string titolo, string autore, int giorniPrestito)
        {
            this.codice = codice;
            this.titolo = titolo;
            this.autore = autore;
            this.giorniPrestito = giorniPrestito;
        }

        public string Codice { get => codice; set => codice = value; }
        public string Titolo { get => titolo; set => titolo = value; }
        public string Autore { get => autore; set => autore = value; }
        public int GiorniPrestito { get => giorniPrestito; set => giorniPrestito = value; }

        public virtual string StampaDettagli()
        {
            return ($"Il codice del libro è {this.Codice}, titolo {this.Titolo}, autore {this.Autore} giorni in prestito {this.GiorniPrestito}");
        }

        public virtual double CalcolaPenaleRitardo()
        {
            return 0.20 * this.GiorniPrestito;
        }
    }

    public class Libro : Risorsa
    {
        int numeroPagine;

        public Libro(string codice, string titolo, string autore, int giorniPrestito, int numeroPagine) : base(codice, titolo, autore, giorniPrestito)
        {
            this.numeroPagine = numeroPagine;

        }

        public int NumeroPagine { get => numeroPagine; set => numeroPagine = value; }

        public override string StampaDettagli()
        {
            return base.StampaDettagli() + ($", numero di pagine {this.NumeroPagine}");
        }

        public override double CalcolaPenaleRitardo()
        {
            return base.CalcolaPenaleRitardo() + 5;
        }
    }

    public class Audiolibro : Risorsa
    {
        int durataMinuti;

        public Audiolibro(string codice, string titolo, string autore, int giorniPrestito, int durataMinuti) : base(codice, titolo, autore, giorniPrestito)
        {
            this.durataMinuti = durataMinuti;
        }

        public int DurataMinuti { get => durataMinuti; set => durataMinuti = value; }

        public override string StampaDettagli()
        {
            return base.StampaDettagli() + ($", durata dell'audiolibro {this.durataMinuti}");
        }

        public override double CalcolaPenaleRitardo()
        {
            return 0.50 + this.GiorniPrestito + (0.01 * this.DurataMinuti);
        }
    }

    public class Gestione
    {
        List<Risorsa> libreria;

        public Gestione(List<Risorsa> libreria)
        {
            this.libreria = libreria;
        }

        public void AggiungiRisorsa(Risorsa risorsa)
        {
            libreria.Add(risorsa);
        }

        public double CalcolaPenaleTotale()
        {
            double tot = 0;

            foreach (Risorsa s in libreria)
                tot += s.CalcolaPenaleRitardo();
            return tot;
        }
    }
}
