using System.Data;
using WinFormsLibraryAlbum;

namespace WinFormsAppDataTable1
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
            comboBoxCategoria.Items.Add("rock");
            comboBoxCategoria.Items.Add("classica");
            comboBoxCategoria.Items.Add("jazz");
            comboBoxCategoria.Items.Add("pop");
            comboBoxCategoria.SelectedIndex = 0;
        }

        /// <summary>
        /// popola la griglia con gli album della categoria selezionata nella comboBox
        /// </summary>
        private void buttonCarica_Click(object sender, EventArgs e)
        {
            if (comboBoxCategoria.SelectedItem == null)
            {
                MessageBox.Show("Nessuna categoria selezionata !");
                return;
            }

            dataGridViewAlbum.DataSource = dati.AlbumDiCategoria(comboBoxCategoria.SelectedItem.ToString());
            dataGridViewBrani.DataSource = null; // svuota la griglia dei brani
            labelPiuVecchio.Text = "Album più vecchio: -";
            labelMedia.Text = "Durata media: -";
        }

        /// <summary>
        /// mostra sui label il titolo dell'album più vecchio e la media della durata
        /// degli album visualizzati nella griglia
        /// </summary>
        private void buttonStatistiche_Click(object sender, EventArgs e)
        {
            DataTable dt = (DataTable)dataGridViewAlbum.DataSource;

            if (dt == null)
            {
                MessageBox.Show("Carica prima gli album !");
                return;
            }

            labelPiuVecchio.Text = "Album più vecchio: " + dati.TitoloPiuVecchio(dt);
            labelMedia.Text = "Durata media: " + dati.MediaDurata(dt).ToString("0.0") + " minuti";
        }

        /// <summary>
        /// selezionando l'album nella griglia, mostra i brani relativi nell'altra griglia
        /// </summary>
        private void dataGridViewAlbum_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0)
                return;

            DataRowView drv = dataGridViewAlbum.Rows[e.RowIndex].DataBoundItem as DataRowView;
            int idAlbum = int.Parse(drv.Row["ID"].ToString());

            dataGridViewBrani.DataSource = dati.BraniAlbum(idAlbum);
        }

        private void buttonChiudi_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}