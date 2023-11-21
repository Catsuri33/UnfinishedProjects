package fr.epicgiant.api.bukkit.lang;

public enum Lang {

    FRENCH("Français", "fr"),
    ENGLISH("English", "en");

    private String name;
    private String language;

    private Lang(String name, String language){

        this.name = name;
        this.language = language;

    }

    public String getName(){
        return name;
    }

    public String getLanguage(){
        return language;
    }

    public static Lang getByName(String name){

        for(Lang lang : Lang.values()){
            if(lang.name.equalsIgnoreCase(name)) return lang;
        }
        return null;
    }

}
