using System.ComponentModel;
using WinFormsLibraryParcoVeicoli;

namespace WinFormsAppParcoVeicoli
{
    public partial class FormInizio : Form
    {
        BindingList<Veicolo> veicoli;

        public FormInizio()
        {
            InitializeComponent();

            veicoli = new BindingList<Veicolo>
            {
                new Auto("AB123CD", "Fiat", "Panda", 15000, 5),
                new Camion("EF456GH", "Iveco", "Daily", 80000, 8.5),
                new Auto("IJ789KL", "Ford", "Mustang", 20000, 3),
                new Camion("MN012OP", "Scania", "R500", 40000, 12)
            };
            dataGridViewVeicoli.DataSource = veicoli;
        }

        private void FormInizio_Load(object sender, EventArgs e)
        {
            comboBoxTipologia.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBoxTipologia.Items.Add("Auto");
            comboBoxTipologia.Items.Add("Camion");

            
            label5.Text = "Numero porte";
            label7.Text = "Capacità di carico";
            label5.Location = label7.Location;

            comboBoxTipologia.SelectedIndex = 0;
        }

        private void buttonAddVeicolo_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(textBoxTarga.Text) ||
                string.IsNullOrWhiteSpace(textBoxMarca.Text) ||
                string.IsNullOrWhiteSpace(textBoxModello.Text) ||
                string.IsNullOrWhiteSpace(textBoxChilometri.Text) ||
                string.IsNullOrWhiteSpace(textBoxNumPorteCarico.Text))
            {
                MessageBox.Show("Compila tutti i campi.");
                return;
            }

            if (!double.TryParse(textBoxChilometri.Text, out double km))
            {
                MessageBox.Show("Chilometri percorsi non validi.");
                return;
            }

            string targa = textBoxTarga.Text;
            string marca = textBoxMarca.Text;
            string modello = textBoxModello.Text;

            if (comboBoxTipologia.SelectedItem?.ToString() == "Auto")
            {
                if (!int.TryParse(textBoxNumPorteCarico.Text, out int porte))
                {
                    MessageBox.Show("Numero di porte non valido.");
                    return;
                }
                veicoli.Add(new Auto(targa, marca, modello, km, porte));
            }
            else
            {
                if (!double.TryParse(textBoxNumPorteCarico.Text, out double capacita))
                {
                    MessageBox.Show("Capacità di carico non valida.");
                    return;
                }
                veicoli.Add(new Camion(targa, marca, modello, km, capacita));
            }
        }

        private void comboBoxTipologia_SelectedIndexChanged(object sender, EventArgs e)
        {
            bool isAuto = comboBoxTipologia.SelectedItem?.ToString() == "Auto";
            label5.Visible = isAuto;
            label7.Visible = !isAuto;
        }

        private void dataGridViewVeicoli_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            Veicolo veicolo = veicoli[e.RowIndex];
            textBoxTarga.Text = veicolo.Targa;
            textBoxMarca.Text = veicolo.Marca;
            textBoxModello.Text = veicolo.Modello;
            textBoxChilometri.Text = veicolo.ChilometriPercorsi.ToString();

            if (veicolo is Auto a)
            {
                comboBoxTipologia.SelectedItem = "Auto";
                textBoxNumPorteCarico.Text = a.NumeroPorte.ToString();
            }
            else if (veicolo is Camion c)
            {
                comboBoxTipologia.SelectedItem = "Camion";
                textBoxNumPorteCarico.Text = c.CapacitaCarico.ToString();
            }
        }
    }
}