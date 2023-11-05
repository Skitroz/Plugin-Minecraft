package fr.skitroz.test.event;

import fr.skitroz.test.Main;
import fr.skitroz.test.chat.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemClear implements Listener {
    public static void EventStarter() {
        new BukkitRunnable() {
            @Override
            public void run() {
                int clearedCount = 0;
                for (World world : Bukkit.getWorlds()) {
                    for (Entity entity : world.getEntities()) {
                        if (entity.getType().name().equals("DROPPED_ITEM")) {
                            entity.remove();
                            clearedCount++;
                        }
                    }
                }

                if (clearedCount == 1){
                    Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT.getMessage() + clearedCount + " item a été supprimé.");
                } else if (clearedCount > 1) {
                    Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT.getMessage() + clearedCount + " items ont été supprimés.");
                } else {
                    Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT.getMessage() + "Aucun item a été supprimé.");
                }
            }
        }.runTaskTimer(Main.INSTANCE, 0L, 12000L);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(ChatManager.MessageType.RIGHT.getMessage() + "Nettoyage des entités dans 10 secondes...");
            }
        }.runTaskTimer(Main.INSTANCE, 11800L, 12000L);
    }
}
