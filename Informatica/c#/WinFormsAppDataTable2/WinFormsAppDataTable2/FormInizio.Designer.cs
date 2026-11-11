namespace WinFormsAppDataTable2
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
            dataGridViewUtenti = new DataGridView();
            labelCognome = new Label();
            labelNome = new Label();
            labelUser = new Label();
            labelPassword = new Label();
            labelEmail = new Label();
            textBoxCognome = new TextBox();
            textBoxNome = new TextBox();
            textBoxUser = new TextBox();
            textBoxPassword = new TextBox();
            textBoxEmail = new TextBox();
            buttonInserisci = new Button();
            buttonLogin = new Button();
            buttonChiudi = new Button();
            ((System.ComponentModel.ISupportInitialize)dataGridViewUtenti).BeginInit();
            SuspendLayout();
            // 
            // dataGridViewUtenti
            // 
            dataGridViewUtenti.BackgroundColor = Color.GhostWhite;
            dataGridViewUtenti.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewUtenti.Location = new Point(73, 20);
            dataGridViewUtenti.Margin = new Padding(3, 4, 3, 4);
            dataGridViewUtenti.Name = "dataGridViewUtenti";
            dataGridViewUtenti.RowHeadersWidth = 51;
            dataGridViewUtenti.Size = new Size(767, 200);
            dataGridViewUtenti.TabIndex = 0;
            // 
            // labelCognome
            // 
            labelCognome.AutoSize = true;
            labelCognome.Location = new Point(73, 243);
            labelCognome.Name = "labelCognome";
            labelCognome.Size = new Size(74, 20);
            labelCognome.TabIndex = 1;
            labelCognome.Text = "Cognome";
            // 
            // labelNome
            // 
            labelNome.AutoSize = true;
            labelNome.Location = new Point(73, 278);
            labelNome.Name = "labelNome";
            labelNome.Size = new Size(50, 20);
            labelNome.TabIndex = 2;
            labelNome.Text = "Nome";
            // 
            // labelUser
            // 
            labelUser.AutoSize = true;
            labelUser.Location = new Point(73, 313);
            labelUser.Name = "labelUser";
            labelUser.Size = new Size(38, 20);
            labelUser.TabIndex = 3;
            labelUser.Text = "User";
            // 
            // labelPassword
            // 
            labelPassword.AutoSize = true;
            labelPassword.Location = new Point(73, 348);
            labelPassword.Name = "labelPassword";
            labelPassword.Size = new Size(70, 20);
            labelPassword.TabIndex = 4;
            labelPassword.Text = "Password";
            // 
            // labelEmail
            // 
            labelEmail.AutoSize = true;
            labelEmail.Location = new Point(73, 383);
            labelEmail.Name = "labelEmail";
            labelEmail.Size = new Size(46, 20);
            labelEmail.TabIndex = 5;
            labelEmail.Text = "Email";
            // 
            // textBoxCognome
            // 
            textBoxCognome.Location = new Point(170, 240);
            textBoxCognome.Name = "textBoxCognome";
            textBoxCognome.Size = new Size(220, 27);
            textBoxCognome.TabIndex = 6;
            // 
            // textBoxNome
            // 
            textBoxNome.Location = new Point(170, 275);
            textBoxNome.Name = "textBoxNome";
            textBoxNome.Size = new Size(220, 27);
            textBoxNome.TabIndex = 7;
            // 
            // textBoxUser
            // 
            textBoxUser.Location = new Point(170, 310);
            textBoxUser.Name = "textBoxUser";
            textBoxUser.Size = new Size(220, 27);
            textBoxUser.TabIndex = 8;
            // 
            // textBoxPassword
            // 
            textBoxPassword.Location = new Point(170, 345);
            textBoxPassword.Name = "textBoxPassword";
            textBoxPassword.Size = new Size(220, 27);
            textBoxPassword.TabIndex = 9;
            textBoxPassword.UseSystemPasswordChar = true;
            // 
            // textBoxEmail
            // 
            textBoxEmail.Location = new Point(170, 380);
            textBoxEmail.Name = "textBoxEmail";
            textBoxEmail.Size = new Size(220, 27);
            textBoxEmail.TabIndex = 10;
            // 
            // buttonInserisci
            // 
            buttonInserisci.Location = new Point(431, 275);
            buttonInserisci.Margin = new Padding(3, 4, 3, 4);
            buttonInserisci.Name = "buttonInserisci";
            buttonInserisci.Size = new Size(220, 40);
            buttonInserisci.TabIndex = 11;
            buttonInserisci.Text = "Inserisci anagrafica e utente";
            buttonInserisci.UseVisualStyleBackColor = true;
            buttonInserisci.Click += buttonInserisci_Click;
            // 
            // buttonLogin
            // 
            buttonLogin.Location = new Point(660, 275);
            buttonLogin.Margin = new Padding(3, 4, 3, 4);
            buttonLogin.Name = "buttonLogin";
            buttonLogin.Size = new Size(180, 40);
            buttonLogin.TabIndex = 12;
            buttonLogin.Text = "Login";
            buttonLogin.UseVisualStyleBackColor = true;
            buttonLogin.Click += buttonLogin_Click;
            // 
            // buttonChiudi
            // 
            buttonChiudi.Font = new Font("Microsoft Sans Serif", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            buttonChiudi.Location = new Point(737, 400);
            buttonChiudi.Margin = new Padding(3, 4, 3, 4);
            buttonChiudi.Name = "buttonChiudi";
            buttonChiudi.Size = new Size(103, 56);
            buttonChiudi.TabIndex = 13;
            buttonChiudi.Text = "&Chiudi";
            buttonChiudi.Click += buttonChiudi_Click;
            // 
            // FormInizio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(920, 480);
            Controls.Add(dataGridViewUtenti);
            Controls.Add(labelCognome);
            Controls.Add(labelNome);
            Controls.Add(labelUser);
            Controls.Add(labelPassword);
            Controls.Add(labelEmail);
            Controls.Add(textBoxCognome);
            Controls.Add(textBoxNome);
            Controls.Add(textBoxUser);
            Controls.Add(textBoxPassword);
            Controls.Add(textBoxEmail);
            Controls.Add(buttonInserisci);
            Controls.Add(buttonLogin);
            Controls.Add(buttonChiudi);
            Margin = new Padding(3, 4, 3, 4);
            Name = "FormInizio";
            Text = "FormInizio";
            Load += FormInizio_Load;
            ((System.ComponentModel.ISupportInitialize)dataGridViewUtenti).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private DataGridView dataGridViewUtenti;
        private Label labelCognome;
        private Label labelNome;
        private Label labelUser;
        private Label labelPassword;
        private Label labelEmail;
        private TextBox textBoxCognome;
        private TextBox textBoxNome;
        private TextBox textBoxUser;
        private TextBox textBoxPassword;
        private TextBox textBoxEmail;
        private Button buttonInserisci;
        private Button buttonLogin;
        private Button buttonChiudi;
    }
}