package fr.skitroz.test.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (cmd.getLabel().equalsIgnoreCase("heal")){
                player.setHealth(20);
                player.setFoodLevel(20);
                player.setSaturation(20);
            }
            if (cmd.getLabel().equalsIgnoreCase("feed")){
                player.setFoodLevel(20);
                player.setSaturation(20);
            }
        }
        return false;
    }
}
