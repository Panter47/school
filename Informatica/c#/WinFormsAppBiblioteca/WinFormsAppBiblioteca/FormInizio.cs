using System.ComponentModel;
using WinFormsLibraryBiblioteca;

namespace WinFormsAppBiblioteca
{
    public partial class FormInizio : Form
    {
        BindingList<Risorsa> libreria;

        public FormInizio()
        {
            InitializeComponent();
            dataGridViewLibreria.DataSource = libreria;
        }

        private void buttonPenale_Click(object sender, EventArgs e)
        {
            
        }
    }
}
