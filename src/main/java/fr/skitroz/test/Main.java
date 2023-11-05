package fr.skitroz.test;

import fr.skitroz.test.cmd.AdminCMD;
import fr.skitroz.test.cmd.LifeCMD;
import fr.skitroz.test.cmd.RdCMD;
import org.bukkit.plugin.java.JavaPlugin;

import fr.skitroz.test.event.ItemClear;

public final class Main extends JavaPlugin {
    public static Main INSTANCE;
    @Override
    public void onEnable() {
        Main.INSTANCE = this;
        System.out.println("Le plugin test s'est bien démarré");
        this.getCommand("rd").setExecutor(new RdCMD());
        this.getCommand("heal").setExecutor(new LifeCMD());
        this.getCommand("feed").setExecutor(new LifeCMD());
        this.getCommand("ec").setExecutor(new AdminCMD());
        this.getCommand("invsee").setExecutor(new AdminCMD());
        this.getCommand("fly").setExecutor(new AdminCMD());
        this.getCommand("god").setExecutor(new AdminCMD());
        this.getCommand("vanish").setExecutor(new AdminCMD());
        this.getCommand("speed").setExecutor(new AdminCMD());
        ItemClear.EventStarter();
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin test s'est bien arrêté");
    }
}
