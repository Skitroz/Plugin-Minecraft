package fr.skitroz.test.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getLabel().equalsIgnoreCase("test")){
                player.sendMessage("Coucou toi uwu");
                player.setFoodLevel(5);
            }
        }
        return false;
    }
}
