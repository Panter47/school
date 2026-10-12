using System.ComponentModel;
using WinFormsLibraryScuola;

namespace WinFormsAppScuola
{
    public partial class FormInizio : Form
    {
        BindingList<Studente> studenti;
        public FormInizio()
        {
            InitializeComponent();
            studenti = Studente.GetStudenti();
        }

        private void ButtonCaricaStudenti_Click(object sender, EventArgs e)
        {
            dataGridViewStudenti.DataSource = studenti;
        }

        private void dataGridViewStudenti_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            Studente studente = ((BindingList<Studente>)dataGridViewStudenti.DataSource)[e.RowIndex];
            if (e.ColumnIndex == 0)
            {
                //Studente studente = Studente.GetStudenti()[e.RowIndex];

                //essageBox.Show(studente.Cognome);
                List<int> voti = studente.Voti;
                var v = voti.Select(vo => new { Voto = vo }).Cast<object>().ToList();
                //dataGridViewVoti.DataSource = v;
                FormVoti formVoti = new FormVoti(v);
                formVoti.ShowDialog();

            }
            else
            {
                textBoxMatricola.Text = studente.Matricola.ToString();
                textBoxnome.Text = studente.Nome;
                textBoxCognome.Text = studente.Cognome;
                textBoxDataNascita.Text = studente.DataNascita.ToString();
            }
        }

        private void buttonCancella_Click(object sender, EventArgs e)
        {
            ((BindingList<Studente>)dataGridViewStudenti.DataSource).RemoveAt(1);
        }

        private void buttoninserisciStudente_Click(object sender, EventArgs e)
        {
            Studente s = new Studente(Convert.ToInt32(textBoxMatricola.Text), textBoxnome.Text, textBoxCognome.Text, DateTime.Parse(textBoxDataNascita.Text), new List<int> { 3, 4, 5 });
            ((BindingList<Studente>)dataGridViewStudenti.DataSource).Add(s);
        }

        private void buttonModificaStudente_Click(object sender, EventArgs e)
        {
           /* foreach (Studente s in studenti)
                if (s.Matricola.ToString() == textBoxMatricola.Text)
                {
                    s.Cognome = textBoxCognome.Text;
                    s.Nome = textBoxnome.Text;
                    s.DataNascita = DateTime.Parse(textBoxDataNascita.Text);
                    dataGridViewStudenti.Refresh();
                }*/
            Studente studente = studenti.FirstOrDefault(s => s.Matricola.ToString() == textBoxMatricola.Text);
            if (studente != null)
            {
                studente.Cognome = textBoxCognome.Text;
                studente.Nome = textBoxnome.Text;
                studente.DataNascita = DateTime.Parse(textBoxDataNascita.Text);
                dataGridViewStudenti.Refresh();
            }

            
        }
    }
}
