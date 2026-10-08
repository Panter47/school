using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using WinFormsLibraryScuola;

namespace WinFormsAppScuola
{
    public partial class FormVoti : Form
    {
        List<object> voti;
        public FormVoti(List<object> v)
        {
            InitializeComponent();
            this.voti = v;
            dataGridViewVoti.DataSource = v;
        }
    }
}
