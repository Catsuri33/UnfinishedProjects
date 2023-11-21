namespace MasterMind
{
    partial class Form1
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            this.textBoxReponse = new System.Windows.Forms.TextBox();
            this.button4Numbers = new System.Windows.Forms.Button();
            this.button3Numbers = new System.Windows.Forms.Button();
            this.button5Numbers = new System.Windows.Forms.Button();
            this.buttonOK = new System.Windows.Forms.Button();
            this.listBoxReponse = new System.Windows.Forms.ListBox();
            this.labelWin = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // textBoxReponse
            // 
            this.textBoxReponse.Font = new System.Drawing.Font("Consolas", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBoxReponse.Location = new System.Drawing.Point(12, 536);
            this.textBoxReponse.MaxLength = 5;
            this.textBoxReponse.Name = "textBoxReponse";
            this.textBoxReponse.Size = new System.Drawing.Size(390, 64);
            this.textBoxReponse.TabIndex = 0;
            this.textBoxReponse.TextChanged += new System.EventHandler(this.textBoxReponse_TextChanged);
            this.textBoxReponse.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBoxReponse_KeyPress);
            // 
            // button4Numbers
            // 
            this.button4Numbers.Location = new System.Drawing.Point(408, 41);
            this.button4Numbers.Name = "button4Numbers";
            this.button4Numbers.Size = new System.Drawing.Size(75, 23);
            this.button4Numbers.TabIndex = 1;
            this.button4Numbers.Text = "4 chiffres";
            this.button4Numbers.UseVisualStyleBackColor = true;
            this.button4Numbers.Click += new System.EventHandler(this.button4Numbers_Click);
            // 
            // button3Numbers
            // 
            this.button3Numbers.Location = new System.Drawing.Point(408, 12);
            this.button3Numbers.Name = "button3Numbers";
            this.button3Numbers.Size = new System.Drawing.Size(75, 23);
            this.button3Numbers.TabIndex = 2;
            this.button3Numbers.Text = "3 chiffres";
            this.button3Numbers.UseVisualStyleBackColor = true;
            this.button3Numbers.Click += new System.EventHandler(this.button3Numbers_Click);
            // 
            // button5Numbers
            // 
            this.button5Numbers.Location = new System.Drawing.Point(408, 70);
            this.button5Numbers.Name = "button5Numbers";
            this.button5Numbers.Size = new System.Drawing.Size(75, 23);
            this.button5Numbers.TabIndex = 3;
            this.button5Numbers.Text = "5 chiffres";
            this.button5Numbers.UseVisualStyleBackColor = true;
            this.button5Numbers.Click += new System.EventHandler(this.button5Numbers_Click);
            // 
            // buttonOK
            // 
            this.buttonOK.Location = new System.Drawing.Point(408, 536);
            this.buttonOK.Name = "buttonOK";
            this.buttonOK.Size = new System.Drawing.Size(75, 64);
            this.buttonOK.TabIndex = 4;
            this.buttonOK.Text = "OK";
            this.buttonOK.UseVisualStyleBackColor = true;
            this.buttonOK.Click += new System.EventHandler(this.buttonOK_Click);
            // 
            // listBoxReponse
            // 
            this.listBoxReponse.Font = new System.Drawing.Font("Consolas", 36F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listBoxReponse.FormattingEnabled = true;
            this.listBoxReponse.ItemHeight = 56;
            this.listBoxReponse.Location = new System.Drawing.Point(12, 12);
            this.listBoxReponse.Name = "listBoxReponse";
            this.listBoxReponse.Size = new System.Drawing.Size(390, 508);
            this.listBoxReponse.TabIndex = 5;
            // 
            // labelWin
            // 
            this.labelWin.BackColor = System.Drawing.Color.White;
            this.labelWin.Font = new System.Drawing.Font("Microsoft Sans Serif", 42F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelWin.Location = new System.Drawing.Point(12, 536);
            this.labelWin.Name = "labelWin";
            this.labelWin.Size = new System.Drawing.Size(390, 64);
            this.labelWin.TabIndex = 6;
            this.labelWin.Text = "Gagné !!";
            this.labelWin.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(494, 612);
            this.Controls.Add(this.labelWin);
            this.Controls.Add(this.listBoxReponse);
            this.Controls.Add(this.buttonOK);
            this.Controls.Add(this.button5Numbers);
            this.Controls.Add(this.button3Numbers);
            this.Controls.Add(this.button4Numbers);
            this.Controls.Add(this.textBoxReponse);
            this.Name = "Form1";
            this.Text = "Master Mind";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxReponse;
        private System.Windows.Forms.Button button4Numbers;
        private System.Windows.Forms.Button button3Numbers;
        private System.Windows.Forms.Button button5Numbers;
        private System.Windows.Forms.Button buttonOK;
        private System.Windows.Forms.ListBox listBoxReponse;
        private System.Windows.Forms.Label labelWin;
    }
}

