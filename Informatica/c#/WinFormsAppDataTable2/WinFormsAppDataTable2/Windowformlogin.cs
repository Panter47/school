using System.Data;
using WinFormsLibraryUtente;

namespace WinFormsAppDataTable2
{
    public partial class WindowFormLogin : Form
    {
        private Dati dati;

        // riceve la stessa istanza di Dati della form iniziale
        public WindowFormLogin(Dati dati)
        {
            InitializeComponent();
            this.dati = dati;
        }

        /// <summary>
        /// simula il login: se user e password sono corretti mostra nome, cognome ed email dell'utente
        /// </summary>
        private void buttonAccedi_Click(object sender, EventArgs e)
        {
            DataRow riga = dati.Login(textBoxUser.Text, textBoxPassword.Text);

            if (riga != null)
            {
                MessageBox.Show("Login riuscito !" +
                                "\nNome: " + riga["Nome"].ToString() +
                                "\nCognome: " + riga["Cognome"].ToString() +
                                "\nEmail: " + riga["Email"].ToString());
                Close();
            }
            else
                MessageBox.Show("User o password errati !");
        }

        private void buttonChiudi_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}