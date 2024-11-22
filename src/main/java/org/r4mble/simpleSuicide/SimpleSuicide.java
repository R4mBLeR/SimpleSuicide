package org.r4mble.simpleSuicide;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.r4mble.simpleSuicide.commands.SuicideCommand;

public final class SimpleSuicide extends JavaPlugin {

    public static FileConfiguration config;
    @Override
    public void onEnable() {
        getCommand("suicide").setExecutor(new SuicideCommand());
        saveDefaultConfig();
        config = getConfig();
        getLogger().info("Configuration is loaded.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
