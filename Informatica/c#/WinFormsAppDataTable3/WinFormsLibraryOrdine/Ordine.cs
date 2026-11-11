using System.Data;

namespace WinFormsLibraryOrdine
{
    public class Ordine
    {
        int idOrdine;
        int idCliente;
        string data;

        public Ordine(int idOrdine, int idCliente, string data)
        {
            this.idOrdine = idOrdine;
            this.idCliente = idCliente;
            this.data = data;
        }

        public int IdOrdine { get => idOrdine; set => idOrdine = value; }
        public int IdCliente { get => idCliente; set => idCliente = value; }
        public string Data { get => data; set => data = value; }

        public static List<Ordine> GetSampleData()
        {
            return new List<Ordine>
            {
                new Ordine(2012, 1210, "12/12/2020"),
                new Ordine(9020, 801, "01/04/2021"),
                new Ordine(3340, 651, "12/06/2021"),
            };
        }
    }

    public class Articolo
    {
        string nomeArticolo;
        int idOrdine;
        double importo;

        public Articolo(string nomeArticolo, int idOrdine, double importo)
        {
            this.nomeArticolo = nomeArticolo;
            this.idOrdine = idOrdine;
            this.importo = importo;
        }

        public string NomeArticolo { get => nomeArticolo; set => nomeArticolo = value; }
        public int IdOrdine { get => idOrdine; set => idOrdine = value; }
        public double Importo { get => importo; set => importo = value; }

        public static List<Articolo> GetSampleData()
        {
            return new List<Articolo>
            {
                new Articolo("Iphone 15", 2012, 1200.20),
                new Articolo("PC Sony intel i7", 2012, 230.45),
                new Articolo("PC Olidata i7", 9020, 320.50),
                new Articolo("Webcam Logitec", 3340, 31.00),
            };
        }
    }

    public class Dati
    {
        List<Ordine> listaOrdini = Ordine.GetSampleData();
        List<Articolo> listaArticoli = Articolo.GetSampleData();

        public DataTable GetOrdini()
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("IdOrdine", typeof(int)),
                new DataColumn("IdCliente", typeof(int)),
                new DataColumn("Data", typeof(string))
            });

            foreach (Ordine o in listaOrdini)
            {
                dt.Rows.Add(o.IdOrdine, o.IdCliente, o.Data);
            }
            return dt;
        }

        public DataTable GetArticoli()
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("NomeArticolo", typeof(string)),
                new DataColumn("IdOrdine", typeof(int)),
                new DataColumn("Importo", typeof(double))
            });

            foreach (Articolo a in listaArticoli)
            {
                dt.Rows.Add(a.NomeArticolo, a.IdOrdine, a.Importo);
            }
            return dt;
        }

        public DataTable ArticoliPerOrdine(int idOrdine)
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("NomeArticolo", typeof(string)),
                new DataColumn("IdOrdine", typeof(int)),
                new DataColumn("Importo", typeof(double))
            });

            foreach (Articolo a in listaArticoli)
            {
                if (a.IdOrdine == idOrdine)
                    dt.Rows.Add(a.NomeArticolo, a.IdOrdine, a.Importo);
            }
            return dt;
        }

        public double SommaImporti(int idOrdine)
        {
            double somma = 0;

            foreach (Articolo a in listaArticoli)
            {
                if (a.IdOrdine == idOrdine)
                    somma += a.Importo;
            }
            return somma;
        }

        public double MediaImporti(int idOrdine)
        {
            double somma = 0;
            int conta = 0;

            foreach (Articolo a in listaArticoli)
            {
                if (a.IdOrdine == idOrdine)
                {
                    somma += a.Importo;
                    conta++;
                }
            }

            if (conta == 0)
                return 0;

            return somma / conta;
        }
        public void InserisciArticolo(string nomeArticolo, int idOrdine, double importo)
        {
            listaArticoli.Add(new Articolo(nomeArticolo, idOrdine, importo));
        }
    }
}