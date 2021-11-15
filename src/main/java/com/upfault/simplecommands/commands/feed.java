package com.upfault.simplecommands.commands;

import com.upfault.simplecommands.SimpleCommands;
import com.upfault.simplecommands.utils.Utilities;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //check if enabled
        if (SimpleCommands.getInstance().getConfig().get("feed-command").equals(false)) {
            Utilities.warnPlayer(sender, SimpleCommands.getPhrase("command-disabled"));
            return true;
        }

        // verify that the user has proper permissions
        if (!sender.hasPermission("simplecommands.user")) {
            Utilities.warnPlayer(sender, SimpleCommands.getPhrase("no-permissions-message"));
            return true;
        }

        String [] arr = {"§aYour stomach stops rumbling..", "§aYour hunger was satiated..", "§aYou're no longer hungry.."};
        Random random = new Random();

        // randomly selects an index from the arr
        int select = random.nextInt(arr.length);

        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("feed")) {
                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage(arr[select]);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1f, 1f);
        }
        return true;
    }
}