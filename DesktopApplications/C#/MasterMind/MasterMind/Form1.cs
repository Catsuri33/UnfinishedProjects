using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MasterMind
{
    public partial class Form1 : Form
    {
        Random Nb = new Random();
        int codeSecret;
        int longueurCodeSecret = 3;



        public Form1()
        {
            InitializeComponent();
            buttonOK.Enabled = false;
            this.button3Numbers_Click(this, null);



        }

        private void textBoxReponse_TextChanged(object sender, EventArgs e)
        {
            if (textBoxReponse.Text == "" || textBoxReponse.Text == " " || textBoxReponse.Text == "  " || textBoxReponse.Text == "   " || textBoxReponse.Text == "    " || textBoxReponse.Text == "     ")
            {
                buttonOK.Enabled = false;
            }
            else
            {
                buttonOK.Enabled = true;
            }
        }

        private void buttonOK_Click(object sender, EventArgs e)
        {
            int bad = 0;
            int good = 0;

            string ChaineCodeSecret = codeSecret.ToString("D" + longueurCodeSecret.ToString());
            if (textBoxReponse.Text.Length == longueurCodeSecret)
            {
                if (textBoxReponse.Text == ChaineCodeSecret)
                {
                    labelWin.Visible = true;
                    textBoxReponse.Enabled = false;
                    listBoxReponse.Items.Add(textBoxReponse.Text);
                    textBoxReponse.Clear();
                }
                else
                {
                    bool[] utiliseCodeSecret = new bool[longueurCodeSecret];
                    bool[] utiliseProposition = new bool[longueurCodeSecret];
                    for (int i = 0; i < longueurCodeSecret; i++)
                    {
                        if (ChaineCodeSecret[i] == textBoxReponse.Text[i])
                        {
                            utiliseCodeSecret[i] = true;
                            utiliseProposition[i] = true;
                            good++;
                        }
                    }

                    for (int i = 0; i < longueurCodeSecret; i++)
                    {
                        for (int j = 0; j < longueurCodeSecret; j++)
                        {
                            if (j != i)
                            {
                                if (ChaineCodeSecret[j] == textBoxReponse.Text[i] && !utiliseCodeSecret[j] && !utiliseProposition[i])
                                {
                                    utiliseCodeSecret[j] = true;
                                    utiliseProposition[i] = true;
                                    bad++;
                                }
                            }
                        }
                    }

                    listBoxReponse.Items.Add(textBoxReponse.Text + "  B:" + good + " M:" + bad);
                    textBoxReponse.Clear();

                }

            }
        }

        private void button4Numbers_Click(object sender, EventArgs e)
        {
            this.codeSecret = Nb.Next(0, 9999);
            listBoxReponse.Items.Clear();
            textBoxReponse.MaxLength = 4;
            longueurCodeSecret = textBoxReponse.MaxLength;
            labelWin.Visible = false;
            textBoxReponse.Enabled = true;

        }

        private void button3Numbers_Click(object sender, EventArgs e)
        {
            this.codeSecret = Nb.Next(0, 999);
            listBoxReponse.Items.Clear();
            textBoxReponse.MaxLength = 3;
            longueurCodeSecret = textBoxReponse.MaxLength;
            labelWin.Visible = false;
            textBoxReponse.Enabled = true;
        }

        private void button5Numbers_Click(object sender, EventArgs e)
        {
            this.codeSecret = Nb.Next(0, 99999);
            listBoxReponse.Items.Clear();
            textBoxReponse.MaxLength = 5;
            longueurCodeSecret = textBoxReponse.MaxLength;
            labelWin.Visible = false;
            textBoxReponse.Enabled = true;
        }

        private void textBoxReponse_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)13)
            {
                this.buttonOK_Click(sender, null);
            }
        }
    }
}
