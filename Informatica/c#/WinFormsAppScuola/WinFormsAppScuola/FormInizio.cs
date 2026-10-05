using WinFormsLibraryScuola;

namespace WinFormsAppScuola
{
    public partial class FormInizio : Form
    {
        public FormInizio()
        {
            InitializeComponent();
        }

        private void ButtonCaricaStudenti_Click(object sender, EventArgs e)
        {
            dataGridViewStudenti.DataSource = Studente.GetStudenti();
        }

        private void dataGridViewStudenti_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 0)
            {
                //Studente studente = Studente.GetStudenti()[e.RowIndex];
                Studente studente = ((List<Studente>)dataGridViewStudenti.DataSource)[e.RowIndex];
                //essageBox.Show(studente.Cognome);
                List<int> voti = studente.Voti;
                var v = voti.Select(vo=> new { Voto=vo }).ToList();
                dataGridViewVoti.DataSource = v;
            }
        }

    }
}
