package fr.catsuri33.minefight.launcher;

import fr.litarvan.openauth.AuthenticationException;
import fr.theshark34.openlauncherlib.util.Saver;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.colored.SColoredBar;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import static fr.theshark34.swinger.Swinger.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LauncherPanel extends JPanel implements SwingerEventListener {

    private Image background = Swinger.getResource("background.png");

    private Saver saver = new Saver(new File(Launcher.MF_DIR, "launcher.properties"));

    private JTextField emailField = new JTextField(saver.get("email"));
    private JPasswordField passwordField = new JPasswordField();

    private STexturedButton playButton = new STexturedButton(getResource("play.png"));
    private STexturedButton quitButton = new STexturedButton(getResource("quit.png"));
    private STexturedButton hideButton = new STexturedButton(getResource("hide.png"));

    private SColoredBar progressBar = new SColoredBar(getTransparentWhite(100), getTransparentWhite(175));
    private JLabel infoLabel = new JLabel("Clique sur Jouer !", SwingConstants.CENTER);

    public LauncherPanel(){
        this.setLayout(null);

        emailField.setForeground(Color.WHITE);
        emailField.setFont(emailField.getFont().deriveFont(30F));
        emailField.setCaretColor(Color.WHITE);
        emailField.setOpaque(false);
        emailField.setBorder(null);
        emailField.setBounds(597, 226, 319, 56);
        this.add(emailField);

        passwordField.setForeground(Color.WHITE);
        passwordField.setFont(emailField.getFont());
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        passwordField.setBounds(597, 343, 319, 56);
        this.add(passwordField);

        playButton.setBounds(618, 438);
        playButton.addEventListener(this);
        this.add(playButton);

        quitButton.setBounds(955, 5);
        quitButton.addEventListener(this);
        this.add(quitButton);

        hideButton.setBounds(940, 5);
        hideButton.addEventListener(this);
        this.add(hideButton);

        progressBar.setBounds(4, 607, 966, 13);
        this.add(progressBar);

        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(emailField.getFont().deriveFont(20F));
        infoLabel.setBounds(275, 575, 966, 25);
        this.add(infoLabel);
    }

    @Override
    public void onEvent(SwingerEvent e){
        if(e.getSource() == playButton){
            setFieldsEnabled(false);

            if(emailField.getText().replaceAll(" ", "").length() == 0 || passwordField.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "Erreur, veuillez entrer un email et un mot de passe valides !", "Erreur", JOptionPane.ERROR_MESSAGE);
                setFieldsEnabled(true);
                return;
            }

            Thread t = new Thread(){
                @Override
                public void run(){

                    try {
                        Launcher.auth(emailField.getText(), passwordField.getText());
                    } catch (AuthenticationException e){
                        JOptionPane.showMessageDialog(LauncherPanel.this, "Erreur, impossible de se connecter : " + e.getErrorModel().getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        setFieldsEnabled(true);
                        return;
                    }

                    try {
                        Launcher.update();
                    } catch (Exception e){
                        Launcher.interruptThread();
                        JOptionPane.showMessageDialog(LauncherPanel.this, "Erreur, impossible de mettre le jeu à jour : " + e, "Erreur", JOptionPane.ERROR_MESSAGE);
                        setFieldsEnabled(true);
                        return;
                    }

                    System.out.println("Ca marche !");

                }
            };
            t.start();

        } else if(e.getSource() == quitButton)
            System.exit(0);
          else if(e.getSource() == hideButton)
            LauncherFrame.getInstance().setState(JFrame.ICONIFIED);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawFullsizedImage(graphics, this, background);
    }

    private void setFieldsEnabled(boolean enabled){
        emailField.setEnabled(enabled);
        passwordField.setEnabled(enabled);
        playButton.setEnabled(enabled);
    }

    public SColoredBar getProgressBar(){
        return progressBar;
    }

    public void setInfoText(String text){
        infoLabel.setText(text);
    }
}
