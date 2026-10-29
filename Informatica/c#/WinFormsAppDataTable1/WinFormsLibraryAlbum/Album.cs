using System;
using System.Collections.Generic;
using System.Data;

namespace WinFormsLibraryAlbum
{
    public class Album
    {
        int id;
        string titolo;
        string autore;
        int anno;
        string categoria;
        int durataMinuti;

        public Album(int id, string titolo, string autore, int anno, string categoria, int durataMinuti)
        {
            this.ID = id;
            this.Titolo = titolo;
            this.Autore = autore;
            this.Anno = anno;
            this.Categoria = categoria;
            this.DurataMinuti = durataMinuti;
        }

        public int ID { get => id; set => id = value; }
        public string Titolo { get => titolo; set => titolo = value; }
        public string Autore { get => autore; set => autore = value; }
        public int Anno { get => anno; set => anno = value; }
        public string Categoria { get => categoria; set => categoria = value; }
        public int DurataMinuti { get => durataMinuti; set => durataMinuti = value; }

        public static List<Album> GetSampleData()
        {
            return new List<Album> {
                new Album(190290, "The dark side of the moon", "Pink Floyd", 1973, "rock", 57),
                new Album(2903123, "Variazioni Goldberg", "Bach", 1741, "classica", 51),
                new Album(2609101, "The Visitors", "ABBA", 1981, "pop", 62),
                new Album(93401, "Kind of Blue", "Miles Davis", 1959, "jazz", 48)
            };
        }
    }

    public class Brani
    {
        int idAlbum;
        string titolo;

        public Brani(int idAlbum, string titolo)
        {
            this.IDAlbum = idAlbum;
            this.Titolo = titolo;
        }

        public int IDAlbum { get => idAlbum; set => idAlbum = value; }
        public string Titolo { get => titolo; set => titolo = value; }

        // IDAlbum è collegato all'ID dell'album restituito da Album.GetSampleData()
        public static List<Brani> GetSampleData()
        {
            return new List<Brani> {
                new Brani(190290, "Speak to Me"),
                new Brani(190290, "Breathe"),
                new Brani(190290, "Time"),
                new Brani(190290, "Money"),
                new Brani(190290, "Us and Them"),
                new Brani(190290, "Brain Damage"),
                new Brani(190290, "Eclipse"),

                new Brani(2903123, "Aria"),
                new Brani(2903123, "Variatio 1"),
                new Brani(2903123, "Variatio 2"),
                new Brani(2903123, "Variatio 3 - Canone all'unisono"),

                new Brani(2609101, "The Visitors"),
                new Brani(2609101, "Head Over Heels"),
                new Brani(2609101, "When All Is Said and Done"),
                new Brani(2609101, "Soldiers"),

                new Brani(93401, "So What"),
                new Brani(93401, "Freddie Freeloader"),
                new Brani(93401, "Blue in Green"),
                new Brani(93401, "All Blues"),
                new Brani(93401, "Flamenco Sketches")
            };
        }
    }

    public class Dati
    {
        /// <summary>
        /// Crea la DataTable con tutti gli album di GetSampleData, la filtra per categoria,
        /// clona la struttura in un'altra DataTable e ricopia solo le righe filtrate
        /// </summary>
        public DataTable AlbumDiCategoria(string categoria)
        {
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[] {
                    new("ID"),
                    new DataColumn("Titolo"),
                    new DataColumn("Autore"),
                    new DataColumn("Anno"),
                    new DataColumn("Categoria"),
                    new DataColumn("DurataMinuti")
                });
            foreach (Album a in Album.GetSampleData())
                dt.Rows.Add(a.ID, a.Titolo, a.Autore, a.Anno, a.Categoria, a.DurataMinuti);

            DataRow[] rowsFiltrate = dt.Select("Categoria = '" + categoria + "'");  // Filtra righe dalla dt
            DataTable dt2 = dt.Clone(); // clona SOLO struttura

            foreach (DataRow row in rowsFiltrate)
                dt2.ImportRow(row);

            return dt2;
        }

        /// <summary>
        /// Scorre la dt passata e restituisce il titolo dell'album con anno minore
        /// </summary>
        public string TitoloPiuVecchio(DataTable dt)
        {
            string titolo = "nessun album";
            int annoMinimo = int.MaxValue;

            foreach (DataRow riga in dt.Rows)
                if (int.Parse(riga["Anno"].ToString()) < annoMinimo)
                {
                    annoMinimo = int.Parse(riga["Anno"].ToString());
                    titolo = riga["Titolo"].ToString();
                }

            return titolo;
        }

        /// <summary>
        /// Scorre la dt passata e restituisce la media (in minuti) della durata degli album
        /// </summary>
        public double MediaDurata(DataTable dt)
        {
            int somma = 0;

            foreach (DataRow riga in dt.Rows)
                somma += int.Parse(riga["DurataMinuti"].ToString());

            if (dt.Rows.Count == 0)
                return 0;

            return (double)somma / dt.Rows.Count;
        }

        /// <summary>
        /// Restituisce in una DataTable i brani dell'album con l'ID passato
        /// </summary>
        public DataTable BraniAlbum(int idAlbum)
        {
            DataTable dt = new DataTable();
            dt.Columns.AddRange(new DataColumn[] {
                    new("IDAlbum"),
                    new DataColumn("Titolo")
                });
            foreach (Brani b in Brani.GetSampleData())
                if (b.IDAlbum == idAlbum)
                    dt.Rows.Add(b.IDAlbum, b.Titolo);

            return dt;
        }
    }
}