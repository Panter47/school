using System.ComponentModel;
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
                Studente studente = ((BindingList<Studente>)dataGridViewStudenti.DataSource)[e.RowIndex];
                //essageBox.Show(studente.Cognome);
                List<int> voti = studente.Voti;
                var v = voti.Select(vo => new { Voto = vo }).Cast<object>().ToList();
                //dataGridViewVoti.DataSource = v;
                FormVoti formVoti = new FormVoti(v);
                formVoti.ShowDialog();

            }
        }

        private void buttonCancella_Click(object sender, EventArgs e)
        {
            ((BindingList<Studente>)dataGridViewStudenti.DataSource).RemoveAt(1);
        }

        private void buttoninserisciStudente_Click(object sender, EventArgs e)
        {
            Studente s = new Studente(Convert.ToInt32(textBoxMatricola.Text),textBoxnome.Text,textBoxCognome.Text,DateTime.Parse(textBoxDataNascita.Text), new List<int> { 3, 4, 5 });
            ((BindingList<Studente>)dataGridViewStudenti.DataSource).Add(s);
        }
    }
}
