namespace WinFormsAppScuola
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
            ButtonCaricaStudenti = new Button();
            dataGridViewStudenti = new DataGridView();
            Carica = new DataGridViewButtonColumn();
            buttonCancella = new Button();
            textBoxMatricola = new TextBox();
            textBoxnome = new TextBox();
            textBoxCognome = new TextBox();
            textBoxDataNascita = new TextBox();
            buttoninserisciStudente = new Button();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            buttonModificaStudente = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewStudenti).BeginInit();
            SuspendLayout();
            // 
            // ButtonCaricaStudenti
            // 
            ButtonCaricaStudenti.Location = new Point(12, 12);
            ButtonCaricaStudenti.Name = "ButtonCaricaStudenti";
            ButtonCaricaStudenti.Size = new Size(188, 29);
            ButtonCaricaStudenti.TabIndex = 0;
            ButtonCaricaStudenti.Text = "Carica Dati Studenti";
            ButtonCaricaStudenti.UseVisualStyleBackColor = true;
            ButtonCaricaStudenti.Click += ButtonCaricaStudenti_Click;
            // 
            // dataGridViewStudenti
            // 
            dataGridViewStudenti.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewStudenti.Columns.AddRange(new DataGridViewColumn[] { Carica });
            dataGridViewStudenti.Location = new Point(216, 12);
            dataGridViewStudenti.Name = "dataGridViewStudenti";
            dataGridViewStudenti.RowHeadersWidth = 51;
            dataGridViewStudenti.Size = new Size(554, 188);
            dataGridViewStudenti.TabIndex = 1;
            dataGridViewStudenti.CellContentClick += dataGridViewStudenti_CellContentClick;
            // 
            // Carica
            // 
            Carica.HeaderText = "Carica";
            Carica.MinimumWidth = 6;
            Carica.Name = "Carica";
            Carica.Text = "Click";
            Carica.UseColumnTextForButtonValue = true;
            Carica.Width = 125;
            // 
            // buttonCancella
            // 
            buttonCancella.Location = new Point(12, 72);
            buttonCancella.Name = "buttonCancella";
            buttonCancella.Size = new Size(188, 29);
            buttonCancella.TabIndex = 3;
            buttonCancella.Text = "Cancella";
            buttonCancella.UseVisualStyleBackColor = true;
            buttonCancella.Click += buttonCancella_Click;
            // 
            // textBoxMatricola
            // 
            textBoxMatricola.ForeColor = SystemColors.WindowText;
            textBoxMatricola.Location = new Point(23, 250);
            textBoxMatricola.Name = "textBoxMatricola";
            textBoxMatricola.Size = new Size(125, 27);
            textBoxMatricola.TabIndex = 4;
            // 
            // textBoxnome
            // 
            textBoxnome.Location = new Point(169, 250);
            textBoxnome.Name = "textBoxnome";
            textBoxnome.Size = new Size(125, 27);
            textBoxnome.TabIndex = 5;
            // 
            // textBoxCognome
            // 
            textBoxCognome.Location = new Point(315, 251);
            textBoxCognome.Name = "textBoxCognome";
            textBoxCognome.Size = new Size(125, 27);
            textBoxCognome.TabIndex = 6;
            // 
            // textBoxDataNascita
            // 
            textBoxDataNascita.Location = new Point(457, 250);
            textBoxDataNascita.Name = "textBoxDataNascita";
            textBoxDataNascita.Size = new Size(125, 27);
            textBoxDataNascita.TabIndex = 7;
            // 
            // buttoninserisciStudente
            // 
            buttoninserisciStudente.Location = new Point(658, 250);
            buttoninserisciStudente.Name = "buttoninserisciStudente";
            buttoninserisciStudente.Size = new Size(94, 29);
            buttoninserisciStudente.TabIndex = 8;
            buttoninserisciStudente.Text = "inserisci";
            buttoninserisciStudente.UseVisualStyleBackColor = true;
            buttoninserisciStudente.Click += buttoninserisciStudente_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(23, 227);
            label1.Name = "label1";
            label1.Size = new Size(72, 20);
            label1.TabIndex = 9;
            label1.Text = "Matricola";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(169, 227);
            label2.Name = "label2";
            label2.Size = new Size(0, 20);
            label2.TabIndex = 10;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(179, 226);
            label3.Name = "label3";
            label3.Size = new Size(50, 20);
            label3.TabIndex = 11;
            label3.Text = "Nome";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(315, 228);
            label4.Name = "label4";
            label4.Size = new Size(74, 20);
            label4.TabIndex = 12;
            label4.Text = "Cognome";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(457, 227);
            label5.Name = "label5";
            label5.Size = new Size(108, 20);
            label5.TabIndex = 13;
            label5.Text = "Data di nascita";
            // 
            // buttonModificaStudente
            // 
            buttonModificaStudente.Location = new Point(658, 285);
            buttonModificaStudente.Name = "buttonModificaStudente";
            buttonModificaStudente.Size = new Size(94, 29);
            buttonModificaStudente.TabIndex = 14;
            buttonModificaStudente.Text = "Modifica";
            buttonModificaStudente.UseVisualStyleBackColor = true;
            buttonModificaStudente.Click += buttonModificaStudente_Click;
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(863, 450);
            Controls.Add(buttonModificaStudente);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(buttoninserisciStudente);
            Controls.Add(textBoxDataNascita);
            Controls.Add(textBoxCognome);
            Controls.Add(textBoxnome);
            Controls.Add(textBoxMatricola);
            Controls.Add(buttonCancella);
            Controls.Add(dataGridViewStudenti);
            Controls.Add(ButtonCaricaStudenti);
            Name = "FormInizio";
            Text = "Scuola";
            ((System.ComponentModel.ISupportInitialize)dataGridViewStudenti).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button ButtonCaricaStudenti;
        private DataGridView dataGridViewStudenti;
        private DataGridViewButtonColumn Carica;
        private Button buttonCancella;
        private TextBox textBoxMatricola;
        private TextBox textBoxnome;
        private TextBox textBoxCognome;
        private TextBox textBoxDataNascita;
        private Button buttoninserisciStudente;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Button buttonModificaStudente;
    }
}
