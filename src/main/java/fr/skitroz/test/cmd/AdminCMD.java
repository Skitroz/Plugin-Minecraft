package fr.skitroz.test.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (label.equalsIgnoreCase("fly")) {
                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage("Vous pouvez maintenant voler.");
                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage("Le vol a été désactivé.");
                }
            }

            if (label.equalsIgnoreCase("gmod")) {
                if (!player.isInvulnerable()) {
                    player.setInvulnerable(true);
                    player.sendMessage("Vous êtes maintenant invulnérable.");
                } else {
                    player.setInvulnerable(false);
                    player.sendMessage("Vous n'êtes plus invulnérable.");
                }
            }
        }

        return true;
    }
}
