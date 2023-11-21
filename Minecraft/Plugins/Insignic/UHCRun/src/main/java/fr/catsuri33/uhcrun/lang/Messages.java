package fr.catsuri33.uhcrun.lang;

public enum Messages {

    PREFIX("§c[§6UHCRun§c] "),

    JOIN_MESSAGE_EN(" §ajoined the game !"),
    QUIT_MESSAGE_EN(" §cleft the game !"),
    GAME_START_MESSAGE_EN("§eThe game start ! Good luck !"),
    GAME_ALREADY_START_EN("§cThe game has already started ! You have been put in spectator !"),
    PVP_ACTIVATED_EN("§cPvp is now activated !"),

    JOIN_MESSAGE_FR(" §aa rejoint la partie !"),
    QUIT_MESSAGE_FR(" §ca quitté la partie !"),
    GAME_START_MESSAGE_FR("§eLa partie commence ! Bonne chance !"),
    GAME_ALREADY_START_FR("§cLa partie est déjà commencée ! Vous avez été mis en spectateur !"),
    PVP_ACTIVATED_FR("§cLe pvp est désormais activé !");

    private final String message;

    Messages(String message){

        this.message = message;

    }

    public String getMessage() {

        return message;

    }
}
