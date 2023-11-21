package fr.catsuri33.minefight.launcher;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;

public class LauncherFrame extends JFrame {

    private static LauncherFrame instance;
    private LauncherPanel launcherPanel;

    public LauncherFrame(){
        this.setTitle("MineFight Launcher");
        this.setSize(975, 625);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setIconImage(Swinger.getResource("Logo MineFight Launcher.png"));
        this.setContentPane(launcherPanel = new LauncherPanel());

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        this.setVisible(true);
    }

    public static void main(String[] args){

        Swinger.setSystemLookNFeel();
        Swinger.setResourcePath("/fr/catsuri33/minefight/launcher/ressources/");

        instance = new LauncherFrame();

    }

    public static LauncherFrame getInstance(){
        return instance;
    }

    public LauncherPanel getLauncherPanel(){
        return this.launcherPanel;
    }

}
