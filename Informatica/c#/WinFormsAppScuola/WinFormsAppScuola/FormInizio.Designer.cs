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
            dataGridViewVoti = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dataGridViewStudenti).BeginInit();
            ((System.ComponentModel.ISupportInitialize)dataGridViewVoti).BeginInit();
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
            // dataGridViewVoti
            // 
            dataGridViewVoti.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewVoti.Location = new Point(216, 231);
            dataGridViewVoti.Name = "dataGridViewVoti";
            dataGridViewVoti.RowHeadersWidth = 51;
            dataGridViewVoti.Size = new Size(300, 188);
            dataGridViewVoti.TabIndex = 2;
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(dataGridViewVoti);
            Controls.Add(dataGridViewStudenti);
            Controls.Add(ButtonCaricaStudenti);
            Name = "FormInizio";
            Text = "Scuola";
            ((System.ComponentModel.ISupportInitialize)dataGridViewStudenti).EndInit();
            ((System.ComponentModel.ISupportInitialize)dataGridViewVoti).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private Button ButtonCaricaStudenti;
        private DataGridView dataGridViewStudenti;
        private DataGridViewButtonColumn Carica;
        private DataGridView dataGridViewVoti;
    }
}
