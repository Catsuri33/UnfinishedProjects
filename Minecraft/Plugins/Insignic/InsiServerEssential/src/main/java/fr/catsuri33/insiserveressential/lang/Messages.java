package fr.catsuri33.insiserveressential.lang;

public enum Messages {

    PREFIX("§bInsiServer§fEssential §6» "),

    LOGIN_2FA_EN("§cOpen the GoogleAuthenticator application and provide the six digit code !"),
    ERROR_SPECIFY_NUMBER_EN("§cError, you must specify a number as an argument !"),
    ERROR_SPECIFY_PLAYER_EN("§cError, you must specify a player as an argument !"),
    ERROR_SPECIFY_REASON_EN("§cError, you must specify a reason as an argument !"),
    ERROR_PERMISSION_EN("§cError, you don't have the permission to execute this command !"),
    ERROR_COMMAND_SPEED_EN("§cError, the command is §e/speed <Amount> <Player> §c!"),
    ERROR_COMMAND_SETSLOTS_EN("§cError, the command is §e/setslots <Amount> §c!"),
    ERROR_COMMAND_KICKALL_EN("§cError, the command is §e/kickall §c!"),
    ERROR_COMMAND_KICK_EN("§cError, the command is §e/kick <Player> <Reason> §c!"),

    LOGIN_2FA_FR("§cOuvrez l'application GoogleAuthenticator et fournissez le code à six chiffres !"),
    ERROR_SPECIFY_NUMBER_FR("§cErreur, vous devez spécifier un nombre en argument !"),
    ERROR_SPECIFY_PLAYER_FR("§cErreur, vous devez spécifier un joueur en argument !"),
    ERROR_SPECIFY_REASON_FR("§cErreur, vous devez spécifier une raison en argument !"),
    ERROR_PERMISSION_FR("§cErreur, vous n'avez pas la permission d'exéctuter cette commande !"),
    ERROR_COMMAND_SPEED_FR("§cErreur, la commande est §e/speed <Nombre> <Joueur> §c!"),
    ERROR_COMMAND_SETSLOTS_FR("§cErreur, la commande est §e/setslots <Nombre> §c!"),
    ERROR_COMMAND_KICKALL_FR("§cErreur, la commande est §e/kickall §c!"),
    ERROR_COMMAND_KICK_FR("§cErreur, la commande est §e/kick <Joueur> <Raison> §c!");

    private final String message;

    Messages(String message){

        this.message = message;

    }

    public String getMessage() {

        return message;

    }

}
