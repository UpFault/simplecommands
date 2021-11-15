package com.upfault.simplecommands.commands;

import com.upfault.simplecommands.SimpleCommands;
import com.upfault.simplecommands.utils.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // verify that the user has proper permissions
        if (!sender.hasPermission("simplecommands.op")) {
            Utilities.warnPlayer(sender, SimpleCommands.getPhrase("no-permissions-message"));
            return true;
        }

        if (!(args.length == 1)) {
            Utilities.warnPlayer(sender, SimpleCommands.getPhrase("formatting-error-message"));
            return true;
        }

        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("reload")) {
            SimpleCommands.reload(player);
        }
        return true;
    }
}
