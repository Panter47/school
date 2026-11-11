using System.Data;
using WinFormsLibraryOrdine;

namespace WinFormsAppDataTable3
{
    public partial class WindowsFormArticoli : Form
    {
        private Dati dati;
        private int idOrdine;

        public WindowsFormArticoli(Dati dati, int idOrdine)
        {
            InitializeComponent();
            this.dati = dati;
            this.idOrdine = idOrdine;
        }

        private void WindowsFormArticoli_Load(object sender, EventArgs e)
        {
            labelOrdine.Text = "Articoli dell'ordine " + idOrdine;
            dataGridViewArticoli.DataSource = dati.ArticoliPerOrdine(idOrdine);
        }


        private void buttonCalcola_Click(object sender, EventArgs e)
        {
            labelSomma.Text = "Somma importi: " + dati.SommaImporti(idOrdine).ToString("0.00");
            labelMedia.Text = "Media importi: " + dati.MediaImporti(idOrdine).ToString("0.00");
        }


        private void buttonInserisci_Click(object sender, EventArgs e)
        {
            double importo;

            if (textBoxNome.Text.Trim() == "")
            {
                MessageBox.Show("Inserisci il nome dell'articolo !");
                return;
            }

            if (!double.TryParse(textBoxImporto.Text, out importo))
            {
                MessageBox.Show("Importo non valido !");
                return;
            }

            dati.InserisciArticolo(textBoxNome.Text.Trim(), idOrdine, importo);

            dataGridViewArticoli.DataSource = dati.ArticoliPerOrdine(idOrdine);

            textBoxNome.Text = "";
            textBoxImporto.Text = "";
            labelSomma.Text = "Somma importi: -";
            labelMedia.Text = "Media importi: -";
        }

        private void buttonChiudi_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}