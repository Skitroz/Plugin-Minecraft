package fr.skitroz.test.cmd;

import fr.skitroz.test.chat.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.Speed;

public class AdminCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getLabel().equalsIgnoreCase("fly")) {
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu peux maintenant voler.");
                        return true;
                    } else {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Le vol a été désactivé.");
                        return true;
                    }
                }
                if (args.length == 1 ){
                    if (Bukkit.getPlayer(args[0]) != null){
                        Player target = Bukkit.getPlayer(args[0]);
                        if (!target.getAllowFlight()){
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() +  player.getName() + " t'a donné le pouvoir de voler.");
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as donné le pouvoir de voler à " + target.getName() + ".");
                            return true;
                            } else {
                                target.setFlying(false);
                                target.setAllowFlight(false);
                                target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() +  player.getName() + " t'a retiré le pouvoir de voler.");
                                player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as retiré le pouvoir de voler à " + target.getName() + ".");
                                return true;
                        }
                    }
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                    return true;
                }
            }

            if (cmd.getLabel().equalsIgnoreCase("god")) {
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    if (!player.isInvulnerable()) {
                        player.setInvulnerable(true);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Vous êtes maintenant invulnérable.");
                        return true;
                    } else {
                        player.setInvulnerable(false);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Vous n'êtes plus invulnérable.");
                        return true;
                    }
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        if (!target.isInvulnerable()){
                            target.setInvulnerable(true);
                            target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu es maintenant invulnérable grâce à " + player.getName() + ".");
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as mis invulnérable " + target.getName() + ".");
                            return true;
                        } else {
                            player.setInvulnerable(false);
                            target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + player.getName() + " t'a enlevé le fait d'être invulnérable.");
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as enlevé " + target.getName() + " de l'invulnérabilité");
                            return true;
                        }
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                        return true;
                    }
                }
            }

            if (cmd.getLabel().equalsIgnoreCase("vanish")){
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    if (!player.isInvisible()) {
                        player.setInvisible(true);
                        player.setCanPickupItems(false);
                        player.setCollidable(false);
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu es maintenant en vanish.");
                        return true;
                    } else {
                        player.setInvisible(false);
                        player.setCanPickupItems(true);
                        player.setCollidable(true);
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu n'es plus en vanish.");
                        return true;
                    }
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        if (!target.isInvisible()) {
                            target.setInvisible(true);
                            target.setCanPickupItems(false);
                            target.setCollidable(false);
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as mis en vanish " + target.getName() + ".");
                            target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + player.getName() + "t'a mis en vanish.");
                            return true;
                        } else {
                            target.setInvisible(false);
                            target.setCanPickupItems(true);
                            target.setCollidable(true);
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu as enlevé le vanish à " + target.getName() + ".");
                            target.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + player.getName() + "t'a enlevé le vanish.");
                            return true;
                        }
                    }
                }
            }
            if (cmd.getLabel().equalsIgnoreCase("ec")){
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    player.openInventory(player.getEnderChest()).setTitle("Ender Chest - " + player.getName());
                    return true;
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        player.openInventory(target.getEnderChest()).setTitle("Ender Chest - " + target.getName());
                        return true;
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                        return true;
                    }
                }
            }
            if (cmd.getLabel().equalsIgnoreCase("invsee")){
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "/invsee <joueur>");
                    return true;
                }
                if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null){
                        player.openInventory(target.getInventory()).setTitle("Player Inventory - " + target.getName());
                        return true;
                    } else {
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Le joueur est introuvable.");
                        return true;
                    }
                }
            }
            if (cmd.getLabel().equalsIgnoreCase("speed"));{
                if (!player.isOp()) {player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "Tu n'as pas la permission d'utiliser cette commande !"); return false;}
                if (args.length == 0){
                    player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "/speed <valeur> ou /speed reset");
                    return true;
                }
                if (args.length == 1){
                    if (args[0].equalsIgnoreCase("1")){
                        player.setWalkSpeed(0.2f);
                        player.setFlySpeed(0.2f);
                        player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu retournes à la vitesse normal.");
                        return true;
                    }
                    try{
                        int speedValue = Integer.parseInt(args[0]);
                        if (speedValue >= 2f && speedValue <= 10f){
                            player.setWalkSpeed(speedValue / 10f);
                            player.setFlySpeed(speedValue / 10f);
                            player.sendMessage(ChatManager.MessageType.CLASSIC.getMessage() + "Tu vas " + speedValue +"x plus vite.");
                            return true;
                        } else {
                            player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "La valeur doit être entre 2 et 10.");
                            return true;
                        }
                    } catch (NumberFormatException e){
                        player.sendMessage(ChatManager.MessageType.ERROR.getMessage() + "La valeur doit être un nombre valide.");
                        return true;
                    }
                }
            }
        }

        return true;
    }
}
