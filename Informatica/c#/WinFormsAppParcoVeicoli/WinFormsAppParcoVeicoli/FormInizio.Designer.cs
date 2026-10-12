namespace WinFormsAppParcoVeicoli
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
            buttonAddVeicolo = new Button();
            dataGridViewVeicoli = new DataGridView();
            textBoxTarga = new TextBox();
            textBoxMarca = new TextBox();
            textBoxModello = new TextBox();
            textBoxChilometri = new TextBox();
            textBoxNumPorteCarico = new TextBox();
            comboBoxTipologia = new ComboBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            labelTipologia = new Label();
            label7 = new Label();
            ((System.ComponentModel.ISupportInitialize)dataGridViewVeicoli).BeginInit();
            SuspendLayout();
            // 
            // buttonAddVeicolo
            // 
            buttonAddVeicolo.Location = new Point(12, 39);
            buttonAddVeicolo.Name = "buttonAddVeicolo";
            buttonAddVeicolo.Size = new Size(94, 29);
            buttonAddVeicolo.TabIndex = 0;
            buttonAddVeicolo.Text = "Aggiungi Veicolo";
            buttonAddVeicolo.UseVisualStyleBackColor = true;
            buttonAddVeicolo.Click += buttonAddVeicolo_Click;
            // 
            // dataGridViewVeicoli
            // 
            dataGridViewVeicoli.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewVeicoli.Location = new Point(12, 169);
            dataGridViewVeicoli.Name = "dataGridViewVeicoli";
            dataGridViewVeicoli.RowHeadersWidth = 51;
            dataGridViewVeicoli.Size = new Size(754, 269);
            dataGridViewVeicoli.TabIndex = 1;
            dataGridViewVeicoli.CellContentClick += dataGridViewVeicoli_CellContentClick;
            // 
            // textBoxTarga
            // 
            textBoxTarga.Location = new Point(112, 41);
            textBoxTarga.Name = "textBoxTarga";
            textBoxTarga.Size = new Size(125, 27);
            textBoxTarga.TabIndex = 2;
            // 
            // textBoxMarca
            // 
            textBoxMarca.Location = new Point(243, 41);
            textBoxMarca.Name = "textBoxMarca";
            textBoxMarca.Size = new Size(125, 27);
            textBoxMarca.TabIndex = 3;
            // 
            // textBoxModello
            // 
            textBoxModello.Location = new Point(374, 41);
            textBoxModello.Name = "textBoxModello";
            textBoxModello.Size = new Size(125, 27);
            textBoxModello.TabIndex = 4;
            // 
            // textBoxChilometri
            // 
            textBoxChilometri.Location = new Point(505, 41);
            textBoxChilometri.Name = "textBoxChilometri";
            textBoxChilometri.Size = new Size(125, 27);
            textBoxChilometri.TabIndex = 5;
            // 
            // textBoxNumPorteCarico
            // 
            textBoxNumPorteCarico.Location = new Point(641, 41);
            textBoxNumPorteCarico.Name = "textBoxNumPorteCarico";
            textBoxNumPorteCarico.Size = new Size(125, 27);
            textBoxNumPorteCarico.TabIndex = 6;
            // 
            // comboBoxTipologia
            // 
            comboBoxTipologia.FormattingEnabled = true;
            comboBoxTipologia.Location = new Point(12, 112);
            comboBoxTipologia.Name = "comboBoxTipologia";
            comboBoxTipologia.Size = new Size(151, 28);
            comboBoxTipologia.TabIndex = 7;
            comboBoxTipologia.SelectedIndexChanged += comboBoxTipologia_SelectedIndexChanged;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(112, 18);
            label1.Name = "label1";
            label1.Size = new Size(45, 20);
            label1.TabIndex = 8;
            label1.Text = "Targa";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(243, 18);
            label2.Name = "label2";
            label2.Size = new Size(50, 20);
            label2.TabIndex = 9;
            label2.Text = "Marca";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(374, 18);
            label3.Name = "label3";
            label3.Size = new Size(65, 20);
            label3.TabIndex = 10;
            label3.Text = "Modello";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(505, 18);
            label4.Name = "label4";
            label4.Size = new Size(133, 20);
            label4.TabIndex = 11;
            label4.Text = "Chilometri Percorsi";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(641, -1);
            label5.Name = "label5";
            label5.Size = new Size(109, 20);
            label5.TabIndex = 12;
            label5.Text = "Numero porte/";
            // 
            // labelTipologia
            // 
            labelTipologia.AutoSize = true;
            labelTipologia.Location = new Point(12, 89);
            labelTipologia.Name = "labelTipologia";
            labelTipologia.Size = new Size(125, 20);
            labelTipologia.TabIndex = 13;
            labelTipologia.Text = "Tipologia veicolo";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(641, 18);
            label7.Name = "label7";
            label7.Size = new Size(128, 20);
            label7.TabIndex = 14;
            label7.Text = "Capacita di carico";
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label7);
            Controls.Add(labelTipologia);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(comboBoxTipologia);
            Controls.Add(textBoxNumPorteCarico);
            Controls.Add(textBoxChilometri);
            Controls.Add(textBoxModello);
            Controls.Add(textBoxMarca);
            Controls.Add(textBoxTarga);
            Controls.Add(dataGridViewVeicoli);
            Controls.Add(buttonAddVeicolo);
            Name = "FormInizio";
            Text = "FormInizio";
            Load += FormInizio_Load;
            ((System.ComponentModel.ISupportInitialize)dataGridViewVeicoli).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonAddVeicolo;
        private DataGridView dataGridViewVeicoli;
        private TextBox textBoxTarga;
        private TextBox textBoxMarca;
        private TextBox textBoxModello;
        private TextBox textBoxChilometri;
        private TextBox textBoxNumPorteCarico;
        private ComboBox comboBoxTipologia;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label labelTipologia;
        private Label label7;
    }
}
