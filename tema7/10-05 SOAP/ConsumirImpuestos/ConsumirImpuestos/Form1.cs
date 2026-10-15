using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirImpuestos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            srImpuestos.ServicioFacturacionCodigosClient cliente = new srImpuestos.ServicioFacturacionCodigosClient();
            using (new OperationContextScope(cliente.InnerChannel))
            {
                var httpRequest = new HttpRequestMessageProperty();

                httpRequest.Headers["apiKey"] =
                    "TokenApi eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmcGlubzY3NzVAaG90bWFpbC5jb20iLCJjb2RpZ29TaXN0ZW1hIjoiMzUzMkM4NzQ5OTFFQjI2OUUzQjciLCJuaXQiOiJINHNJQUFBQUFBQUFBRE14TWpFMk1UUTBNTFFBQU4xUlVKc0tBQUFBIiwiaWQiOjYyMjE0OTEsImV4cCI6MTgxNDM1MzMwNSwiaWF0IjoxNzgyODMxNjc1LCJuaXREZWxlZ2FkbyI6NDYzMTMxNzAxNSwic3Vic2lzdGVtYSI6IlNGRSJ9.rszKArqgmxcpGflMpK8438QBHWFFAH5uu290eAr87lWXjSaVpqhMWJNV5i1qa0Mfo0ouNvkhEfGBdnd8zSCBJQ";
                OperationContext.Current.OutgoingMessageProperties[
                    HttpRequestMessageProperty.Name] = httpRequest;

                srImpuestos.respuestaComunicacion respuesta =
                    cliente.verificarComunicacion();
            }

        }
    }
}
