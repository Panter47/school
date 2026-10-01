namespace WinFormsAppPrima
{
    partial class FormPrima
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
            ButtonCliccami = new Button();
            buttonSecondo = new Button();
            SuspendLayout();
            // 
            // ButtonCliccami
            // 
            ButtonCliccami.Location = new Point(370, 136);
            ButtonCliccami.Name = "ButtonCliccami";
            ButtonCliccami.Size = new Size(94, 29);
            ButtonCliccami.TabIndex = 0;
            ButtonCliccami.Text = "Cliccami ";
            ButtonCliccami.UseVisualStyleBackColor = true;
            ButtonCliccami.Click += ButtonCliccami_Click;
            // 
            // buttonSecondo
            // 
            buttonSecondo.Location = new Point(385, 286);
            buttonSecondo.Name = "buttonSecondo";
            buttonSecondo.Size = new Size(94, 29);
            buttonSecondo.TabIndex = 1;
            buttonSecondo.Text = "decremento";
            buttonSecondo.UseVisualStyleBackColor = true;
            buttonSecondo.Click += buttonSecondo_Click;
            // 
            // FormPrima
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(995, 580);
            Controls.Add(buttonSecondo);
            Controls.Add(ButtonCliccami);
            Name = "FormPrima";
            Text = "Prova";
            Load += FormPrima_Load;
            ResumeLayout(false);
        }

        #endregion

        private Button ButtonCliccami;
        private Button buttonSecondo;
    }
}
