package fr.skitroz.test.cmd;

import fr.skitroz.test.Main;
import fr.skitroz.test.chat.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RdCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}

            for (int i = 3; i >= 0; i--) {
                final int secondsLeft = i;
                Main.INSTANCE.getServer().getScheduler().runTaskLater(Main.INSTANCE, () -> {
                    if (player.isOnline()) {
                        Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT + "Le serveur va se reload dans " + secondsLeft + " secondes...");
                    }
                    if (secondsLeft == 0) {
                        Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT + "Reload des plugins en cours...");
                        Main.INSTANCE.getServer().reload();
                    }
                }, (3 - i) * 20L);
            }
        }
        return true;
    }
}
