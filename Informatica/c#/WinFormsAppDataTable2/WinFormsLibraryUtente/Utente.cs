using System.Data;

namespace WinFormsLibraryUtente
{
    public class Utente
    {
        int id;
        string user;
        string password;
        string email;

        public Utente(int id, string user, string password, string email)
        {
            this.id = id;
            this.user = user;
            this.password = password;
            this.email = email;
        }

        public int Id { get => id; set => id = value; }
        public string User { get => user; set => user = value; }
        public string Password { get => password; set => password = value; }
        public string Email { get => email; set => email = value; }

        public static List<Utente> GetSampleData()
        {
            return new List<Utente>
            {
                new Utente(190290,"mirko.bianchi","kjn4_2","mirko.bianchi@itis.pr.it"),
                new Utente(193460,"marco.verdi","poi9_A","marco.verdi@itis.pr.it"),
                new Utente(234746,"marco.verdi1","asAwL_c","marco.verdi1@itis.pr.it"),
            };
        }
    }

    public class Anagrafica
    {
        int id;
        string cognome;
        string nome;

        public Anagrafica(int id, string cognome, string nome)
        {
            this.id = id;
            this.cognome = cognome;
            this.nome = nome;
        }

        public int Id { get => id; set => id = value; }
        public string Cognome { get => cognome; set => cognome = value; }
        public string Nome { get => nome; set => nome = value; }

        public static List<Anagrafica> GetSampleData()
        {
            return new List<Anagrafica>
            {
                new Anagrafica(190290,"Bianchi","Mirko"),
                new Anagrafica(193460,"Verdi","Marco"),
                new Anagrafica(234746,"Verdi","Marco"),
            };
        }
    }

    public class Dati
    {
        List<Anagrafica> listaAnagrafiche = Anagrafica.GetSampleData();
        List<Utente> listaUtenti = Utente.GetSampleData();

        public DataTable GetAnagrafica()
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("ID", typeof(int)),
                new DataColumn("Cognome", typeof(string)),
                new DataColumn("Nome", typeof(string))
            });

            foreach (Anagrafica a in listaAnagrafiche)
            {
                dt.Rows.Add(a.Id, a.Cognome, a.Nome);
            }
            return dt;
        }

        public DataTable GetUtenti()
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("ID", typeof(int)),
                new DataColumn("User", typeof(string)),
                new DataColumn("Password", typeof(string)),
                new DataColumn("Email", typeof(string))
            });

            foreach (Utente u in listaUtenti)
            {
                dt.Rows.Add(u.Id, u.User, u.Password, u.Email);
            }
            return dt;
        }

        public DataTable GetUtentiCompleti()
        {
            DataTable dt = new DataTable();

            dt.Columns.AddRange(new DataColumn[] {
                new DataColumn("ID", typeof(int)),
                new DataColumn("Cognome", typeof(string)),
                new DataColumn("Nome", typeof(string)),
                new DataColumn("User", typeof(string)),
                new DataColumn("Password", typeof(string)),
                new DataColumn("Email", typeof(string))
            });

            foreach (Anagrafica a in listaAnagrafiche)
            {
                foreach (Utente u in listaUtenti)
                {
                    if (a.Id == u.Id)
                    {
                        dt.Rows.Add(a.Id, a.Cognome, a.Nome, u.User, u.Password, u.Email);
                        break;
                    }
                }
            }

            return dt;
        }

        public bool UserEsiste(string user)
        {
            foreach (Utente u in listaUtenti)
            {
                if (u.User.ToLower() == user.ToLower())
                    return true;
            }
            return false;
        }

        private bool IdEsiste(int id)
        {
            foreach (Anagrafica a in listaAnagrafiche)
            {
                if (a.Id == id)
                    return true;
            }
            return false;
        }

        private int NuovoId()
        {
            Random random = new Random();
            int id = random.Next(100000, 1000000);

            while (IdEsiste(id))
                id = random.Next(100000, 1000000);

            return id;
        }

        public bool InserisciUtente(string cognome, string nome, string user, string password, string email)
        {
            if (UserEsiste(user))
                return false;

            int id = NuovoId();
            listaAnagrafiche.Add(new Anagrafica(id, cognome, nome));
            listaUtenti.Add(new Utente(id, user, password, email));
            return true;
        }

        public DataRow Login(string user, string password)
        {
            DataTable dt = GetUtentiCompleti();

            foreach (DataRow riga in dt.Rows)
            {
                if (riga["User"].ToString() == user && riga["Password"].ToString() == password)
                    return riga;
            }
            return null;
        }
    }
}