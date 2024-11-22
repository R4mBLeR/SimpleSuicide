package org.r4mble.simpleSuicide.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.r4mble.simpleSuicide.SimpleSuicide;
import org.jetbrains.annotations.NotNull;

import static org.r4mble.simpleSuicide.SimpleSuicide.config;

public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        if (!player.hasPermission("SimpleSuicide.suicide")) {
            player.sendMessage(config.getString("messages.no-permission"));
            return true;
        }
        player.setHealth(0.0);
        if (SimpleSuicide.config.getBoolean("allow-messages.local-message-allow"))
            player.sendMessage(config.getString("messages.local-message"));
        if (SimpleSuicide.config.getBoolean("allow-messages.global-message-allow")) {
            String msg=config.getString("messages.global-message").replace("%player%", player.getName());
            Bukkit.broadcastMessage(msg);
        }

        return true;
    }
}
