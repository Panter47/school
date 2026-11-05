using System.Data;
using WinFormsLibraryUtente;

namespace WinFormsAppDataTable2
{
    public partial class FormInizio : Form
    {
        private Dati dati = new Dati();

        public FormInizio()
        {
            InitializeComponent();
        }

        /// <summary>
        /// all'avvio mostra nella griglia i dati di GetUtentiCompleti
        /// </summary>
        private void FormInizio_Load(object sender, EventArgs e)
        {
            dataGridViewUtenti.DataSource = dati.GetUtentiCompleti();
        }

        /// <summary>
        /// apre la form di login (stessa istanza di Dati, così vede anche i nuovi utenti)
        /// </summary>
        private void buttonLogin_Click(object sender, EventArgs e)
        {
            WindowFormLogin login = new WindowFormLogin(dati);
            login.ShowDialog();
        }

        /// <summary>
        /// inserisce una nuova anagrafica e un nuovo utente, con verifica omonimia dello user
        /// </summary>
        private void buttonInserisci_Click(object sender, EventArgs e)
        {
            if (textBoxCognome.Text.Trim() == "" || textBoxNome.Text.Trim() == "" ||
                textBoxUser.Text.Trim() == "" || textBoxPassword.Text == "" ||
                textBoxEmail.Text.Trim() == "")
            {
                MessageBox.Show("Compila tutti i campi !");
                return;
            }

            if (dati.InserisciUtente(textBoxCognome.Text.Trim(), textBoxNome.Text.Trim(),
                                     textBoxUser.Text.Trim(), textBoxPassword.Text,
                                     textBoxEmail.Text.Trim()))
            {
                // aggiorna la griglia con la nuova DataTable
                dataGridViewUtenti.DataSource = dati.GetUtentiCompleti();

                textBoxCognome.Text = "";
                textBoxNome.Text = "";
                textBoxUser.Text = "";
                textBoxPassword.Text = "";
                textBoxEmail.Text = "";
            }
            else
                MessageBox.Show("Esiste già un utente con questo user !");
        }

        private void buttonChiudi_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}