namespace WinFormsAppPrima
{
    public partial class FormPrima : Form
    {
        private int counter;

        public FormPrima()
        {
            InitializeComponent();
        }

        private void ButtonCliccami_Click(object sender, EventArgs e)
        {
            MessageBox.Show($"counter: {counter}");
        }

        private void FormPrima_Load(object sender, EventArgs e)
        {
            counter++;
        }

        private void buttonSecondo_Click(object sender, EventArgs e)
        {
            counter--;
        }
    }
}
