using System.Data;
using WinFormsLibraryOrdine;

namespace WinFormsAppDataTable3
{
    public partial class FormInizio : Form
    {
        private Dati dati = new Dati();

        public FormInizio()
        {
            InitializeComponent();
        }

        private void FormInizio_Load(object sender, EventArgs e)
        {
            dataGridViewOrdini.DataSource = dati.GetOrdini();
        }

        private void dataGridViewOrdini_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0)
                return;

            DataRowView drv = dataGridViewOrdini.Rows[e.RowIndex].DataBoundItem as DataRowView;
            int idOrdine = int.Parse(drv.Row["IdOrdine"].ToString());

            WindowsFormArticoli formArticoli = new WindowsFormArticoli(dati, idOrdine);
            formArticoli.ShowDialog();
        }

        private void buttonChiudi_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}