package fr.catsuri33.minefight.launcher;

import fr.litarvan.openauth.AuthPoints;
import fr.litarvan.openauth.AuthenticationException;
import fr.litarvan.openauth.Authenticator;
import fr.litarvan.openauth.model.AuthAgent;
import fr.litarvan.openauth.model.response.AuthResponse;
import fr.theshark34.openlauncherlib.minecraft.*;
import fr.theshark34.supdate.BarAPI;
import fr.theshark34.supdate.SUpdate;
import fr.theshark34.swinger.Swinger;

import java.io.File;

public class Launcher {

    public static final GameVersion MF_VERSION = new GameVersion("1.12.2", GameType.V1_8_HIGHER);
    public static final GameInfos MF_INFOS = new GameInfos("MineFight", MF_VERSION, new GameTweak[]{GameTweak.FORGE});
    public static final File MF_DIR = MF_INFOS.getGameDir();

    private static AuthInfos authInfos;
    private static Thread updateThread;

    public static void auth(String email, String password) throws AuthenticationException {
        Authenticator authenticator = new Authenticator(Authenticator.MOJANG_AUTH_URL, AuthPoints.NORMAL_AUTH_POINTS);
        AuthResponse response = authenticator.authenticate(AuthAgent.MINECRAFT, email, password, "");
        authInfos = new AuthInfos(response.getSelectedProfile().getName(), response.getAccessToken(), response.getSelectedProfile().getId());
    }

    public static void update() throws Exception {
        SUpdate su = new SUpdate("http://minefight-update.ml/", MF_DIR);
        updateThread = new Thread(){

            private int val;
            private int max;

            @Override
            public void run(){

                while(!this.isInterrupted()){
                    val = (int) (BarAPI.getNumberOfTotalDownloadedBytes() / 1000);
                    max = (int) (BarAPI.getNumberOfTotalBytesToDownload() / 1000);

                    LauncherFrame.getInstance().getLauncherPanel().getProgressBar().setMaximum(max);
                    LauncherFrame.getInstance().getLauncherPanel().getProgressBar().setValue(val);

                    LauncherFrame.getInstance().getLauncherPanel().setInfoText("Telechargement des fichiers " + BarAPI.getNumberOfDownloadedFiles() + "/" + BarAPI.getNumberOfFileToDownload() + " " + Swinger.percentage(val, max) + "%");
                }
            }
        };

        updateThread.start();

        su.start();
        updateThread.interrupt();
    }

    public static void interruptThread(){
        updateThread.interrupt();
    }

}
