using System.Drawing.Printing;
using System.Xml.Linq;
using static System.Net.Mime.MediaTypeNames;

namespace WinFormsAppDataTable1
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
            comboBoxCategoria = new ComboBox();
            buttonCarica = new Button();
            buttonStatistiche = new Button();
            dataGridViewAlbum = new DataGridView();
            labelPiuVecchio = new Label();
            labelMedia = new Label();
            dataGridViewBrani = new DataGridView();
            buttonChiudi = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewAlbum).BeginInit();
            ((System.ComponentModel.ISupportInitialize)dataGridViewBrani).BeginInit();
            SuspendLayout();
            // 
            // comboBoxCategoria
            // 
            comboBoxCategoria.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBoxCategoria.FormattingEnabled = true;
            comboBoxCategoria.Location = new Point(73, 33);
            comboBoxCategoria.Margin = new Padding(3, 4, 3, 4);
            comboBoxCategoria.Name = "comboBoxCategoria";
            comboBoxCategoria.Size = new Size(193, 28);
            comboBoxCategoria.TabIndex = 0;
            // 
            // buttonCarica
            // 
            buttonCarica.Location = new Point(273, 30);
            buttonCarica.Margin = new Padding(3, 4, 3, 4);
            buttonCarica.Name = "buttonCarica";
            buttonCarica.Size = new Size(151, 33);
            buttonCarica.TabIndex = 1;
            buttonCarica.Text = "Carica album";
            buttonCarica.UseVisualStyleBackColor = true;
            buttonCarica.Click += buttonCarica_Click;
            // 
            // buttonStatistiche
            // 
            buttonStatistiche.Location = new Point(431, 30);
            buttonStatistiche.Margin = new Padding(3, 4, 3, 4);
            buttonStatistiche.Name = "buttonStatistiche";
            buttonStatistiche.Size = new Size(250, 33);
            buttonStatistiche.TabIndex = 2;
            buttonStatistiche.Text = "Più vecchio e durata media";
            buttonStatistiche.UseVisualStyleBackColor = true;
            buttonStatistiche.Click += buttonStatistiche_Click;
            // 
            // dataGridViewAlbum
            // 
            dataGridViewAlbum.BackgroundColor = Color.Yellow;
            dataGridViewAlbum.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewAlbum.Location = new Point(73, 81);
            dataGridViewAlbum.Margin = new Padding(3, 4, 3, 4);
            dataGridViewAlbum.Name = "dataGridViewAlbum";
            dataGridViewAlbum.RowHeadersWidth = 51;
            dataGridViewAlbum.Size = new Size(767, 200);
            dataGridViewAlbum.TabIndex = 3;
            dataGridViewAlbum.CellContentClick += dataGridViewAlbum_CellContentClick;
            // 
            // labelPiuVecchio
            // 
            labelPiuVecchio.AutoSize = true;
            labelPiuVecchio.Location = new Point(73, 292);
            labelPiuVecchio.Name = "labelPiuVecchio";
            labelPiuVecchio.Size = new Size(120, 20);
            labelPiuVecchio.TabIndex = 4;
            labelPiuVecchio.Text = "Album più vecchio: -";
            // 
            // labelMedia
            // 
            labelMedia.AutoSize = true;
            labelMedia.Location = new Point(73, 320);
            labelMedia.Name = "labelMedia";
            labelMedia.Size = new Size(100, 20);
            labelMedia.TabIndex = 5;
            labelMedia.Text = "Durata media: -";
            // 
            // dataGridViewBrani
            // 
            dataGridViewBrani.BackgroundColor = Color.Yellow;
            dataGridViewBrani.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewBrani.Location = new Point(73, 352);
            dataGridViewBrani.Margin = new Padding(3, 4, 3, 4);
            dataGridViewBrani.Name = "dataGridViewBrani";
            dataGridViewBrani.RowHeadersWidth = 51;
            dataGridViewBrani.Size = new Size(500, 150);
            dataGridViewBrani.TabIndex = 6;
            // 
            // buttonChiudi
            // 
            buttonChiudi.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonChiudi.Location = new Point(700, 440);
            buttonChiudi.Margin = new Padding(3, 4, 3, 4);
            buttonChiudi.Name = "buttonChiudi";
            buttonChiudi.Size = new Size(103, 56);
            buttonChiudi.TabIndex = 7;
            buttonChiudi.Text = "&Chiudi";
            buttonChiudi.Click += buttonChiudi_Click;
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(920, 520);
            Controls.Add(comboBoxCategoria);
            Controls.Add(buttonCarica);
            Controls.Add(buttonStatistiche);
            Controls.Add(dataGridViewAlbum);
            Controls.Add(labelPiuVecchio);
            Controls.Add(labelMedia);
            Controls.Add(dataGridViewBrani);
            Controls.Add(buttonChiudi);
            Margin = new Padding(3, 4, 3, 4);
            Name = "FormInizio";
            Text = "FormInizio";
            Load += FormInizio_Load;
            ((System.ComponentModel.ISupportInitialize)dataGridViewAlbum).EndInit();
            ((System.ComponentModel.ISupportInitialize)dataGridViewBrani).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBoxCategoria;
        private Button buttonCarica;
        private Button buttonStatistiche;
        private DataGridView dataGridViewAlbum;
        private Label labelPiuVecchio;
        private Label labelMedia;
        private DataGridView dataGridViewBrani;
        private Button buttonChiudi;
    }
}