package fr.skitroz.test.cmd;

import fr.skitroz.test.chat.ChatManager;
import org.bukkit.Bukkit;
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
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as été heal.");
                    return true;
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as été heal par " + player.getName() + ".");
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as heal " + target.getName() + ".");
                        return true;
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                        return true;
                    }
                }
            }

            if (cmd.getLabel().equalsIgnoreCase("feed")){
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as été feed.");
                    return true;
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        player.setFoodLevel(20);
                        player.setSaturation(20);
                        target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as été feed par " + player.getName() + ".");
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as feed " + target.getName() + ".");
                        return true;
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
