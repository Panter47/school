namespace WinFormsAppProva
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
            buttonProva = new Button();
            comboBoxProva = new ComboBox();
            labelProva = new Label();
            SuspendLayout();
            // 
            // buttonProva
            // 
            buttonProva.Location = new Point(51, 56);
            buttonProva.Name = "buttonProva";
            buttonProva.Size = new Size(94, 29);
            buttonProva.TabIndex = 0;
            buttonProva.Text = "Prova";
            buttonProva.UseVisualStyleBackColor = true;
            // 
            // comboBoxProva
            // 
            comboBoxProva.FormattingEnabled = true;
            comboBoxProva.Location = new Point(223, 56);
            comboBoxProva.Name = "comboBoxProva";
            comboBoxProva.Size = new Size(151, 28);
            comboBoxProva.TabIndex = 1;
            comboBoxProva.SelectedIndexChanged += comboBoxProva_SelectedIndexChanged;
            // 
            // labelProva
            // 
            labelProva.AutoSize = true;
            labelProva.Location = new Point(424, 65);
            labelProva.Name = "labelProva";
            labelProva.Size = new Size(50, 20);
            labelProva.TabIndex = 2;
            labelProva.Text = "label1";
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(labelProva);
            Controls.Add(comboBoxProva);
            Controls.Add(buttonProva);
            Name = "FormInizio";
            Text = "Form Inizio";
            Load += FormInizio_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonProva;
        private ComboBox comboBoxProva;
        private Label labelProva;
    }
}
