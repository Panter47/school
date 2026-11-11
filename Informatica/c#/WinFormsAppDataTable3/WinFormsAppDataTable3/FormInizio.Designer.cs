namespace WinFormsAppDataTable3
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
            dataGridViewOrdini = new DataGridView();
            labelInfo = new Label();
            buttonChiudi = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewOrdini).BeginInit();
            SuspendLayout();
            // 
            // dataGridViewOrdini
            // 
            dataGridViewOrdini.BackgroundColor = Color.White;
            dataGridViewOrdini.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewOrdini.Location = new Point(73, 20);
            dataGridViewOrdini.Margin = new Padding(3, 4, 3, 4);
            dataGridViewOrdini.Name = "dataGridViewOrdini";
            dataGridViewOrdini.RowHeadersWidth = 51;
            dataGridViewOrdini.Size = new Size(767, 300);
            dataGridViewOrdini.TabIndex = 0;
            dataGridViewOrdini.CellContentClick += dataGridViewOrdini_CellContentClick;
            // 
            // labelInfo
            // 
            labelInfo.AutoSize = true;
            labelInfo.Location = new Point(73, 345);
            labelInfo.Name = "labelInfo";
            labelInfo.Size = new Size(297, 20);
            labelInfo.TabIndex = 1;
            labelInfo.Text = "Clicca su un ordine per vedere i suoi articoli";
            // 
            // buttonChiudi
            // 
            buttonChiudi.Font = new Font("Microsoft Sans Serif", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonChiudi.Location = new Point(737, 340);
            buttonChiudi.Margin = new Padding(3, 4, 3, 4);
            buttonChiudi.Name = "buttonChiudi";
            buttonChiudi.Size = new Size(103, 56);
            buttonChiudi.TabIndex = 2;
            buttonChiudi.Text = "&Chiudi";
            buttonChiudi.Click += buttonChiudi_Click;
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(920, 420);
            Controls.Add(dataGridViewOrdini);
            Controls.Add(labelInfo);
            Controls.Add(buttonChiudi);
            Margin = new Padding(3, 4, 3, 4);
            Name = "FormInizio";
            Text = "FormInizio";
            Load += FormInizio_Load;
            ((System.ComponentModel.ISupportInitialize)dataGridViewOrdini).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView dataGridViewOrdini;
        private Label labelInfo;
        private Button buttonChiudi;
    }
}