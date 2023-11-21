package fr.catsuri33.uhc.utils;

import fr.catsuri33.uhc.UHC;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.*;

public class ConfigUtils {

    private UHC instance;

    public ConfigUtils(UHC instance) {
        this.instance = instance;
    }

    public void saveDefaultConfig(FileConfiguration config) {
        this.instance.saveDefaultConfig();
        if (config.get("anticheat") == null) {
            this.instance.getConfig().set("anticheat", true);
            this.instance.saveConfig();
        }

        if (config.get("world") == null) {
            this.instance.getConfig().set("world", "world");
            this.instance.saveConfig();
        }

        if (config.get("nether") == null) {
            this.instance.getConfig().set("nether", "world_nether");
            this.instance.saveConfig();
        }

        if (config.get("end") == null) {
            this.instance.getConfig().set("end", "world_the_end");
            this.instance.saveConfig();
        }

        if (config.get("lang") == null) {
            this.instance.getConfig().set("lang", "FRENCH");
            this.instance.saveConfig();
        }

        if (config.get("lobbyCenterBlock") == null) {
            this.instance.getConfig().set("lobbyCenterBlock", "IRON_BLOCK");
            this.instance.saveConfig();
        }

        if (config.get("hostconfigs") == null) {
            this.instance.getConfig().createSection("hostconfigs");
            this.instance.saveConfig();
        }

        if (config.get("chunks_to_load_radius") == null) {
            this.instance.getConfig().set("chunks_to_load_radius", 1000);
            this.instance.saveConfig();
        }

    }

    public void saveHostConfig(HostConfig hostConfig) {
        FileConfiguration config = this.instance.getConfig();
        String path = "hostconfigs." + hostConfig.getName() + ".";
        config.set(path + "teamsOf", hostConfig.getTeamOf());
        config.set(path + "maxPlayers", hostConfig.getMaxPlayers());
        config.set(path + "playersBeforeStart", hostConfig.getPlayersBeforeStart());
        config.set(path + "pvptime", hostConfig.getPvpTime());
        config.set(path + "bordertime", hostConfig.getBorderTime());
        config.set(path + "borderspeed", hostConfig.getBorderSpeed());
        config.set(path + "startbordersize", hostConfig.getStartBorderSize());
        config.set(path + "finalbordersize", hostConfig.getFinalBorderSize());
        config.set(path + "suddendeathtime", hostConfig.getSuddenDeathTime());
        config.set(path + "notchApple", hostConfig.isNotchApple());
        config.set(path + "allPotionsEnable", hostConfig.isAllPotionsEnable());
        config.set(path + "nether", hostConfig.isNether());
        config.set(path + "netherEndTime", hostConfig.getNetherEndTime());
        config.set(path + "fightTelportation", hostConfig.isTeleport());
        config.set(path + "fightTelportationTime", hostConfig.getTeleportTime());
        path = "hostconfigs." + hostConfig.getName() + ".inventory.";
        ConfigurationSection inventory = config.createSection("hostconfigs." + hostConfig.getName() + ".inventory");
        ListIterator var5 = hostConfig.getGameInventory().iterator();

        while(true) {
            ItemStack itemStack;
            ConfigurationSection section;
            Iterator var17;
            do {
                Iterator var8;
                do {
                    if (!var5.hasNext()) {
                        List<String> scenarios = new ArrayList();
                        hostConfig.getScenarios().forEach((sx) -> {
                            scenarios.add(sx.getName());
                        });
                        path = "hostconfigs." + hostConfig.getName() + ".scenarios";
                        config.set(path, scenarios);
                        config.createSection("hostconfigs." + hostConfig.getName() + ".lootsrules");
                        config.set("hostconfigs." + hostConfig.getName() + ".lootsrules.apple", LootsRules.getInstance().getLoot(Material.APPLE));
                        config.set("hostconfigs." + hostConfig.getName() + ".lootsrules.feather", LootsRules.getInstance().getLoot(Material.FEATHER));
                        config.set("hostconfigs." + hostConfig.getName() + ".lootsrules.flint", LootsRules.getInstance().getLoot(Material.FLINT));
                        config.set("hostconfigs." + hostConfig.getName() + ".lootsrules.string", LootsRules.getInstance().getLoot(Material.STRING));
                        List<String> deniedPotions = new ArrayList();
                        this.pl.gameManager.getDeniedPotions().forEach((potion) -> {
                            deniedPotions.add(potion.getType() + "," + potion.getLevel() + "," + potion.isSplash());
                        });
                        config.set("hostconfigs." + hostConfig.getName() + ".deniedPotions", deniedPotions);
                        config.createSection("hostconfigs." + hostConfig.getName() + ".customcrafts");
                        ConfigurationSection crafts = config.createSection("hostconfigs." + hostConfig.getName() + ".customcrafts");
                        var8 = hostConfig.getCrafts().iterator();

                        while(var8.hasNext()) {
                            ShapedRecipe recipe = (ShapedRecipe)var8.next();
                            ConfigurationSection craft = crafts.createSection(recipe.getResult().getType().toString());
                            craft.set("amount", recipe.getResult().getAmount());
                            if (recipe.getResult().getDurability() != 0) {
                                craft.set("data", recipe.getResult().getDurability());
                            }

                            craft.set("craft.line", recipe.getShape()[0]);
                            craft.set("craft.line1", recipe.getShape()[1]);
                            craft.set("craft.line2", recipe.getShape()[2]);
                            Iterator var11 = recipe.getIngredientMap().entrySet().iterator();

                            while(var11.hasNext()) {
                                Map.Entry<Character, ItemStack> entry = (Map.Entry)var11.next();
                                craft.set("craft." + entry.getKey(), ((ItemStack)entry.getValue()).getType().toString());
                            }
                        }

                        config.createSection("hostconfigs." + hostConfig.getName() + ".ores");
                        section = config.createSection("hostconfigs." + hostConfig.getName() + ".ores");
                        var17 = hostConfig.getBlocksRules().iterator();

                        while(var17.hasNext()) {
                            BlocksRule blocksRule = (BlocksRule)var17.next();
                            ConfigurationSection rule = section.createSection(blocksRule.id.toString());
                            rule.set("perChunk", blocksRule.round);
                            rule.set("minY", blocksRule.minY);
                            rule.set("maxY", blocksRule.maxY);
                            rule.set("size", blocksRule.size);
                        }

                        this.instance.saveConfig();
                        return;
                    }

                    itemStack = (ItemStack)var5.next();
                } while(itemStack == null);

                int exists = 0;
                var8 = inventory.getKeys(false).iterator();

                while(var8.hasNext()) {
                    String s = (String)var8.next();
                    if (s.contains(itemStack.getType().toString())) {
                        ++exists;
                    }
                }

                if (exists == 0) {
                    section = inventory.createSection(itemStack.getType().toString());
                } else {
                    section = inventory.createSection(itemStack.getType().toString() + exists);
                }

                if (itemStack.getItemMeta().getDisplayName() != null) {
                    section.set(".name", itemStack.getItemMeta().getDisplayName());
                }

                if (itemStack.getItemMeta().getLore() != null) {
                    section.set(".lores", itemStack.getItemMeta().getLore());
                }

                section.set(".amount", itemStack.getAmount());
                if (itemStack.getDurability() != 0) {
                    section.set(".data", itemStack.getDurability());
                }
            } while(itemStack.getEnchantments() == null);

            var17 = itemStack.getEnchantments().entrySet().iterator();

            while(var17.hasNext()) {
                Map.Entry<Enchantment, Integer> enchantmentIntegerEntry = (Map.Entry)var17.next();
                section.set(".enchantements." + ((Enchantment)enchantmentIntegerEntry.getKey()).getName(), enchantmentIntegerEntry.getValue());
            }
        }
    }

    public void removeHostConfig(String name) {
        this.instance.getConfig().set("hostconfigs." + name, (Object)null);
        this.instance.saveConfig();
    }

    public List<HostConfig> getHostConfigs() {
        List<HostConfig> result = new ArrayList();
        FileConfiguration config = this.pl.getConfig();
        ConfigurationSection section = config.getConfigurationSection("hostconfigs");
        if (section == null) {
            return result;
        } else {
            Iterator var4 = section.getKeys(false).iterator();

            while(var4.hasNext()) {
                String s = (String)var4.next();
                int teamsOf = config.getInt("hostconfigs." + s + ".teamsOf");
                int maxPlayers = config.getInt("hostconfigs." + s + ".maxPlayers");
                int playersBeforeStart = config.getInt("hostconfigs." + s + ".playersBeforeStart");
                int pvptime = config.getInt("hostconfigs." + s + ".pvptime");
                int bordertime = config.getInt("hostconfigs." + s + ".bordertime");
                int borderspeed = config.getInt("hostconfigs." + s + ".borderspeed");
                int startbordersize = config.getInt("hostconfigs." + s + ".startbordersize");
                int finalbordersize = config.getInt("hostconfigs." + s + ".finalbordersize");
                int suddendeathtime = config.getInt("hostconfigs." + s + ".suddendeathtime");
                int netherEndTime = config.getInt("hostconfigs." + s + ".netherEndTime");
                int teleportTime = config.getInt("hostconfigs." + s + ".fightTelportationTime");
                boolean notchApple = config.getBoolean("hostconfigs." + s + ".notchApple");
                boolean allPotionsEnable = config.getBoolean("hostconfigs." + s + ".allPotionsEnable");
                boolean nether = config.getBoolean("hostconfigs." + s + ".nether");
                boolean teleport = config.getBoolean("hostconfigs." + s + ".fightTelportation");
                ConfigurationSection inv = config.getConfigurationSection("hostconfigs." + s + ".inventory");
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, InventoryType.PLAYER, "Inventaire de base");
                ItemsCreator ic;
                int flintLootRule;
                int stringLootRule;
                if (inv != null && inv.getKeys(false) != null) {
                    for(Iterator var23 = inv.getKeys(false).iterator(); var23.hasNext(); inventory.addItem(new ItemStack[]{ic.create()})) {
                        String item = (String)var23.next();

                        int subtringsAtEnd;
                        for(subtringsAtEnd = 0; Character.isDigit(item.charAt(item.length() - subtringsAtEnd - 1)); ++subtringsAtEnd) {
                        }

                        Material m = Material.getMaterial(item.substring(0, item.length() - subtringsAtEnd));
                        flintLootRule = inv.getInt(item + ".amount");
                        if (inv.get(item + ".data") != null) {
                            stringLootRule = inv.getInt(item + ".data");
                            ic = new ItemsCreator(m, (String)null, (List)null, flintLootRule, (byte)stringLootRule);
                        } else {
                            ic = new ItemsCreator(m, (String)null, (List)null, flintLootRule);
                        }

                        ConfigurationSection enchants = inv.getConfigurationSection(item + ".enchantements");
                        if (enchants != null) {
                            Iterator var30 = enchants.getKeys(false).iterator();

                            while(var30.hasNext()) {
                                String enchant = (String)var30.next();
                                ic.addEnchantment(Enchantment.getByName(enchant), enchants.getInt(enchant));
                            }
                        }
                    }
                }

                List<String> scenrariosString = config.getStringList("hostconfigs." + s + ".scenarios");
                List<Scenario> scenrarios = new ArrayList();
                Iterator var43 = scenrariosString.iterator();

                while(var43.hasNext()) {
                    String scenario = (String)var43.next();
                    scenrarios.add(Scenarios.getByName(scenario).getScenario());
                }

                ConfigurationSection loots = config.getConfigurationSection("hostconfigs." + s + ".lootsrules");
                int appleLootsRule = 0;
                int featherLootRule = 0;
                flintLootRule = 0;
                stringLootRule = 0;
                if (loots != null) {
                    appleLootsRule = config.getInt("hostconfigs." + s + ".lootsrules.apple");
                    featherLootRule = config.getInt("hostconfigs." + s + ".lootsrules.feather");
                    flintLootRule = config.getInt("hostconfigs." + s + ".lootsrules.flint");
                    stringLootRule = config.getInt("hostconfigs." + s + ".lootsrules.string");
                }

                List<Potion> deniedPotions = new ArrayList();
                Iterator var50 = config.getStringList("hostconfigs." + s + ".deniedPotions").iterator();

                while(var50.hasNext()) {
                    String pot = (String)var50.next();
                    String[] potArray = pot.split(",");
                    deniedPotions.add(new Potion(PotionType.valueOf(potArray[0]), Integer.parseInt(potArray[1]), Boolean.parseBoolean(potArray[2])));
                }

                ConfigurationSection crafts = config.getConfigurationSection("hostconfigs." + s + ".customcrafts");
                List<ShapedRecipe> recipes = new ArrayList();
                if (crafts != null && crafts.getKeys(false) != null) {
                    Iterator var53 = crafts.getKeys(false).iterator();

                    label122:
                    while(true) {
                        String key;
                        do {
                            if (!var53.hasNext()) {
                                break label122;
                            }

                            key = (String)var53.next();
                        } while(key == null);

                        int amount = crafts.getInt(key + ".amount");
                        ItemsCreator ic;
                        if (crafts.get(key + ".data") != null) {
                            ic = new ItemsCreator(Material.getMaterial(key), (String)null, (List)null, amount, (byte)crafts.getInt(crafts + "." + key + ".data"));
                        } else {
                            ic = new ItemsCreator(Material.getMaterial(key), (String)null, (List)null, amount);
                        }

                        ShapedRecipe recipe = new ShapedRecipe(ic.create());
                        recipe.shape(new String[]{crafts.getString(key + ".craft.line"), crafts.getString(key + ".craft.line1"), crafts.getString(key + ".craft.line2")});
                        Iterator var38 = crafts.getConfigurationSection(key + ".craft").getKeys(false).iterator();

                        while(var38.hasNext()) {
                            String ingredient = (String)var38.next();
                            if (!ingredient.contains("line") && !ingredient.contains("amount")) {
                                recipe.setIngredient(ingredient.charAt(0), Material.getMaterial(crafts.getString(key + ".craft." + ingredient.charAt(0))));
                            }
                        }

                        recipes.add(recipe);
                    }
                }

                ConfigurationSection ores = config.getConfigurationSection("hostconfigs." + s + ".ores");
                List<BlocksRule> blocksRules = new ArrayList();
                if (ores != null && ores.getKeys(false) != null) {
                    Iterator var56 = ores.getKeys(false).iterator();

                    while(var56.hasNext()) {
                        String rule = (String)var56.next();
                        if (rule != null) {
                            int perChunk = ores.getInt(rule + ".perChunk");
                            int minY = ores.getInt(rule + ".minY");
                            int maxY = ores.getInt(rule + ".maxY");
                            int size = ores.getInt(rule + ".size");
                            blocksRules.add(new BlocksRule(Material.getMaterial(rule), 0, perChunk, minY, maxY, size));
                        }
                    }
                }

                HostConfig hc = new HostConfig(s, maxPlayers, playersBeforeStart, pvptime, bordertime, startbordersize, finalbordersize, borderspeed, teamsOf, inventory, scenrarios, appleLootsRule, featherLootRule, flintLootRule, stringLootRule, suddendeathtime, notchApple, deniedPotions, allPotionsEnable, nether, netherEndTime, recipes, blocksRules, teleport, teleportTime);
                result.add(hc);
            }

            return result;
        }
    }
}

