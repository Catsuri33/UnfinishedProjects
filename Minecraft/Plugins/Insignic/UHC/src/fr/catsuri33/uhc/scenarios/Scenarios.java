package fr.catsuri33.uhc.scenarios;

import fr.catsuri33.uhc.scenarios.scenarios.CutClean;
import org.bukkit.Material;

public enum Scenarios {
    CUTCLEAN(new CutClean());

    private Scenario scenario;

    private Scenarios(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public static Scenarios getByMaterial(Material type) {
        Scenarios[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Scenarios scenarios = var1[var3];
            if (scenarios.getScenario().getType() == type) {
                return scenarios;
            }
        }

        return null;
    }

    public static Scenarios getByName(String name) {
        Scenarios[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Scenarios scenarios = var1[var3];
            if (scenarios.getScenario().getName().equalsIgnoreCase(name)) {
                return scenarios;
            }
        }

        return null;
    }
}