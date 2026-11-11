namespace WinFormsAppDataTable3
{
    partial class WindowsFormArticoli
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
            labelOrdine = new Label();
            dataGridViewArticoli = new DataGridView();
            buttonCalcola = new Button();
            labelSomma = new Label();
            labelMedia = new Label();
            labelNome = new Label();
            labelImporto = new Label();
            textBoxNome = new TextBox();
            textBoxImporto = new TextBox();
            buttonInserisci = new Button();
            buttonChiudi = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewArticoli).BeginInit();
            SuspendLayout();
            // 
            // labelOrdine
            // 
            labelOrdine.AutoSize = true;
            labelOrdine.Location = new Point(73, 20);
            labelOrdine.Name = "labelOrdine";
            labelOrdine.Size = new Size(132, 20);
            labelOrdine.TabIndex = 0;
            labelOrdine.Text = "Articoli dell'ordine";
            // 
            // dataGridViewArticoli
            // 
            dataGridViewArticoli.BackgroundColor = Color.White;
            dataGridViewArticoli.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewArticoli.Location = new Point(73, 55);
            dataGridViewArticoli.Margin = new Padding(3, 4, 3, 4);
            dataGridViewArticoli.Name = "dataGridViewArticoli";
            dataGridViewArticoli.RowHeadersWidth = 51;
            dataGridViewArticoli.Size = new Size(767, 200);
            dataGridViewArticoli.TabIndex = 1;
            // 
            // buttonCalcola
            // 
            buttonCalcola.Location = new Point(73, 275);
            buttonCalcola.Margin = new Padding(3, 4, 3, 4);
            buttonCalcola.Name = "buttonCalcola";
            buttonCalcola.Size = new Size(220, 40);
            buttonCalcola.TabIndex = 2;
            buttonCalcola.Text = "Calcola somma e media";
            buttonCalcola.UseVisualStyleBackColor = true;
            buttonCalcola.Click += buttonCalcola_Click;
            // 
            // labelSomma
            // 
            labelSomma.AutoSize = true;
            labelSomma.Location = new Point(73, 330);
            labelSomma.Name = "labelSomma";
            labelSomma.Size = new Size(126, 20);
            labelSomma.TabIndex = 3;
            labelSomma.Text = "Somma importi: -";
            // 
            // labelMedia
            // 
            labelMedia.AutoSize = true;
            labelMedia.Location = new Point(73, 360);
            labelMedia.Name = "labelMedia";
            labelMedia.Size = new Size(117, 20);
            labelMedia.TabIndex = 4;
            labelMedia.Text = "Media importi: -";
            // 
            // labelNome
            // 
            labelNome.AutoSize = true;
            labelNome.Location = new Point(73, 408);
            labelNome.Name = "labelNome";
            labelNome.Size = new Size(62, 20);
            labelNome.TabIndex = 5;
            labelNome.Text = "Articolo";
            // 
            // labelImporto
            // 
            labelImporto.AutoSize = true;
            labelImporto.Location = new Point(73, 443);
            labelImporto.Name = "labelImporto";
            labelImporto.Size = new Size(63, 20);
            labelImporto.TabIndex = 6;
            labelImporto.Text = "Importo";
            // 
            // textBoxNome
            // 
            textBoxNome.Location = new Point(170, 405);
            textBoxNome.Name = "textBoxNome";
            textBoxNome.Size = new Size(220, 27);
            textBoxNome.TabIndex = 7;
            // 
            // textBoxImporto
            // 
            textBoxImporto.Location = new Point(170, 440);
            textBoxImporto.Name = "textBoxImporto";
            textBoxImporto.Size = new Size(220, 27);
            textBoxImporto.TabIndex = 8;
            // 
            // buttonInserisci
            // 
            buttonInserisci.Location = new Point(431, 405);
            buttonInserisci.Margin = new Padding(3, 4, 3, 4);
            buttonInserisci.Name = "buttonInserisci";
            buttonInserisci.Size = new Size(220, 40);
            buttonInserisci.TabIndex = 9;
            buttonInserisci.Text = "Inserisci articolo";
            buttonInserisci.UseVisualStyleBackColor = true;
            buttonInserisci.Click += buttonInserisci_Click;
            // 
            // buttonChiudi
            // 
            buttonChiudi.Font = new Font("Microsoft Sans Serif", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonChiudi.Location = new Point(737, 420);
            buttonChiudi.Margin = new Padding(3, 4, 3, 4);
            buttonChiudi.Name = "buttonChiudi";
            buttonChiudi.Size = new Size(103, 56);
            buttonChiudi.TabIndex = 10;
            buttonChiudi.Text = "&Chiudi";
            buttonChiudi.Click += buttonChiudi_Click;
            // 
            // WindowsFormArticoli
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(920, 500);
            Controls.Add(labelOrdine);
            Controls.Add(dataGridViewArticoli);
            Controls.Add(buttonCalcola);
            Controls.Add(labelSomma);
            Controls.Add(labelMedia);
            Controls.Add(labelNome);
            Controls.Add(labelImporto);
            Controls.Add(textBoxNome);
            Controls.Add(textBoxImporto);
            Controls.Add(buttonInserisci);
            Controls.Add(buttonChiudi);
            Margin = new Padding(3, 4, 3, 4);
            Name = "WindowsFormArticoli";
            StartPosition = FormStartPosition.CenterParent;
            Text = "WindowsFormArticoli";
            Load += WindowsFormArticoli_Load;
            ((System.ComponentModel.ISupportInitialize)dataGridViewArticoli).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label labelOrdine;
        private DataGridView dataGridViewArticoli;
        private Button buttonCalcola;
        private Label labelSomma;
        private Label labelMedia;
        private Label labelNome;
        private Label labelImporto;
        private TextBox textBoxNome;
        private TextBox textBoxImporto;
        private Button buttonInserisci;
        private Button buttonChiudi;
    }
}