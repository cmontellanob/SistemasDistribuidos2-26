using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;

namespace ClienteOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int a = int.Parse(txtA.Text);
            int b = int.Parse(txtB.Text);
            String operacion = cbOperacion.SelectedItem.ToString();
            srOperaciones.wsOperacionesSoapClient client = new srOperaciones.wsOperacionesSoapClient();


            switch (operacion)
            {
                case "Suma":
                    lblResultado.Text = client.Sumar(a, b).ToString();
                    break;
                case "Resta":
                    lblResultado.Text = client.Restar(a, b).ToString();
                    break;
                case "Multiplicación":
                    lblResultado.Text = client.Multiplicar(a, b).ToString();
                    break;
                case "División":
                    if (b != 0)
                    {
                        lblResultado.Text = client.Dividir(a, b).ToString();
                    }
                    else
                    {
                        MessageBox.Show("No se puede dividir entre cero.");
                    }
                    break;
                default:
                    MessageBox.Show("Operación no válida.");
                    break;
            }
            }

           }
    }

