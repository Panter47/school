namespace WinFormsAppDataTable2
{
    partial class WindowFormLogin
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
            labelUser = new Label();
            labelPassword = new Label();
            textBoxUser = new TextBox();
            textBoxPassword = new TextBox();
            buttonAccedi = new Button();
            buttonChiudi = new Button();
            SuspendLayout();
            // 
            // labelUser
            // 
            labelUser.AutoSize = true;
            labelUser.Location = new Point(30, 33);
            labelUser.Name = "labelUser";
            labelUser.Size = new Size(38, 20);
            labelUser.TabIndex = 0;
            labelUser.Text = "User";
            // 
            // labelPassword
            // 
            labelPassword.AutoSize = true;
            labelPassword.Location = new Point(30, 83);
            labelPassword.Name = "labelPassword";
            labelPassword.Size = new Size(70, 20);
            labelPassword.TabIndex = 1;
            labelPassword.Text = "Password";
            // 
            // textBoxUser
            // 
            textBoxUser.Location = new Point(130, 30);
            textBoxUser.Name = "textBoxUser";
            textBoxUser.Size = new Size(220, 27);
            textBoxUser.TabIndex = 2;
            // 
            // textBoxPassword
            // 
            textBoxPassword.Location = new Point(130, 80);
            textBoxPassword.Name = "textBoxPassword";
            textBoxPassword.Size = new Size(220, 27);
            textBoxPassword.TabIndex = 3;
            textBoxPassword.UseSystemPasswordChar = true;
            // 
            // buttonAccedi
            // 
            buttonAccedi.Location = new Point(130, 130);
            buttonAccedi.Margin = new Padding(3, 4, 3, 4);
            buttonAccedi.Name = "buttonAccedi";
            buttonAccedi.Size = new Size(120, 40);
            buttonAccedi.TabIndex = 4;
            buttonAccedi.Text = "Accedi";
            buttonAccedi.UseVisualStyleBackColor = true;
            buttonAccedi.Click += buttonAccedi_Click;
            // 
            // buttonChiudi
            // 
            buttonChiudi.Font = new Font("Microsoft Sans Serif", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonChiudi.Location = new Point(260, 130);
            buttonChiudi.Margin = new Padding(3, 4, 3, 4);
            buttonChiudi.Name = "buttonChiudi";
            buttonChiudi.Size = new Size(90, 40);
            buttonChiudi.TabIndex = 5;
            buttonChiudi.Text = "&Chiudi";
            buttonChiudi.Click += buttonChiudi_Click;
            // 
            // WindowFormLogin
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(400, 200);
            Controls.Add(labelUser);
            Controls.Add(labelPassword);
            Controls.Add(textBoxUser);
            Controls.Add(textBoxPassword);
            Controls.Add(buttonAccedi);
            Controls.Add(buttonChiudi);
            Margin = new Padding(3, 4, 3, 4);
            Name = "WindowFormLogin";
            StartPosition = FormStartPosition.CenterParent;
            Text = "WindowFormLogin";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label labelUser;
        private Label labelPassword;
        private TextBox textBoxUser;
        private TextBox textBoxPassword;
        private Button buttonAccedi;
        private Button buttonChiudi;
    }
}