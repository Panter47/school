namespace WinFormsAppBiblioteca
{
    partial class FormInizio
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            buttonAdd = new Button();
            textBoxCodice = new TextBox();
            textBoxTitolo = new TextBox();
            textBoxAutore = new TextBox();
            textBoxGiorniPrestito = new TextBox();
            textBox5 = new TextBox();
            dataGridViewLibreria = new DataGridView();
            buttonPenale = new Button();
            labelPenale = new Label();
            ((System.ComponentModel.ISupportInitialize)dataGridViewLibreria).BeginInit();
            SuspendLayout();
            // 
            // buttonAdd
            // 
            buttonAdd.Location = new Point(12, 51);
            buttonAdd.Name = "buttonAdd";
            buttonAdd.Size = new Size(94, 29);
            buttonAdd.TabIndex = 0;
            buttonAdd.Text = "Aggiungi";
            buttonAdd.UseVisualStyleBackColor = true;
            // 
            // textBoxCodice
            // 
            textBoxCodice.Location = new Point(112, 52);
            textBoxCodice.Name = "textBoxCodice";
            textBoxCodice.Size = new Size(125, 27);
            textBoxCodice.TabIndex = 1;
            // 
            // textBoxTitolo
            // 
            textBoxTitolo.Location = new Point(243, 53);
            textBoxTitolo.Name = "textBoxTitolo";
            textBoxTitolo.Size = new Size(125, 27);
            textBoxTitolo.TabIndex = 2;
            // 
            // textBoxAutore
            // 
            textBoxAutore.Location = new Point(374, 53);
            textBoxAutore.Name = "textBoxAutore";
            textBoxAutore.Size = new Size(125, 27);
            textBoxAutore.TabIndex = 3;
            // 
            // textBoxGiorniPrestito
            // 
            textBoxGiorniPrestito.Location = new Point(505, 53);
            textBoxGiorniPrestito.Name = "textBoxGiorniPrestito";
            textBoxGiorniPrestito.Size = new Size(125, 27);
            textBoxGiorniPrestito.TabIndex = 4;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(636, 53);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(125, 27);
            textBox5.TabIndex = 5;
            // 
            // dataGridViewLibreria
            // 
            dataGridViewLibreria.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewLibreria.Location = new Point(243, 130);
            dataGridViewLibreria.Name = "dataGridViewLibreria";
            dataGridViewLibreria.RowHeadersWidth = 51;
            dataGridViewLibreria.Size = new Size(518, 299);
            dataGridViewLibreria.TabIndex = 6;
            // 
            // buttonPenale
            // 
            buttonPenale.Location = new Point(12, 130);
            buttonPenale.Name = "buttonPenale";
            buttonPenale.Size = new Size(134, 29);
            buttonPenale.TabIndex = 7;
            buttonPenale.Text = "Calcola la penale";
            buttonPenale.UseVisualStyleBackColor = true;
            buttonPenale.Click += buttonPenale_Click;
            // 
            // labelPenale
            // 
            labelPenale.AutoSize = true;
            labelPenale.Location = new Point(30, 211);
            labelPenale.Name = "labelPenale";
            labelPenale.Size = new Size(50, 20);
            labelPenale.TabIndex = 8;
            labelPenale.Text = "label1";
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(labelPenale);
            Controls.Add(buttonPenale);
            Controls.Add(dataGridViewLibreria);
            Controls.Add(textBox5);
            Controls.Add(textBoxGiorniPrestito);
            Controls.Add(textBoxAutore);
            Controls.Add(textBoxTitolo);
            Controls.Add(textBoxCodice);
            Controls.Add(buttonAdd);
            Name = "FormInizio";
            Text = "Gestione Biblioteca";
            ((System.ComponentModel.ISupportInitialize)dataGridViewLibreria).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonAdd;
        private TextBox textBoxCodice;
        private TextBox textBoxTitolo;
        private TextBox textBoxAutore;
        private TextBox textBoxGiorniPrestito;
        private TextBox textBox5;
        private DataGridView dataGridViewLibreria;
        private Button buttonPenale;
        private Label labelPenale;
    }
}
