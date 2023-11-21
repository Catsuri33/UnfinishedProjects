package fr.epicgiant.api.bukkit.utils;

public enum MessagesPreGenerated {

    // Prefix
    SERVER_NAME("§6§lEpic-Giant >§r "),

    // Errors
    ERROR(SERVER_NAME.getMessage() + " §cAn error has occurred. Please try again. If the problem persists please contact a moderator."),
    ERROR_COMMAND_NOT_FOUND(SERVER_NAME.getMessage() + " §cError, command not found !"),
    ERROR_MISSING_PERMISSION(SERVER_NAME.getMessage() + " §cError, you do not have permission to do this!"),

    // Maintenance
    ON_MAINTENANCE_ENABLED(SERVER_NAME.getMessage() + " §2You have just activated the maintenance !"),
    ON_MAINTENANCE_DISABLED(SERVER_NAME.getMessage() + " §cYou have just deactivated the maintenance !"),
    KICK_PLAYER_ON_MAINTENANCE("§cLe serveur entre en maintenance !");

    private final String message;

    MessagesPreGenerated(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
