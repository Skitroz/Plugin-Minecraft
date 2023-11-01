package fr.skitroz.test;

import fr.skitroz.test.cmd.AdminCMD;
import fr.skitroz.test.cmd.LifeCMD;
import fr.skitroz.test.cmd.RdCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main INSTANCE;
    @Override
    public void onEnable() {
        Main.INSTANCE = this;
        System.out.println("Le plugin test s'est bien démarré");
        this.getCommand("rd").setExecutor(new RdCMD());
        this.getCommand("heal").setExecutor(new LifeCMD());
        this.getCommand("feed").setExecutor(new LifeCMD());
        this.getCommand("fly").setExecutor(new AdminCMD());
        this.getCommand("gmod").setExecutor(new AdminCMD());
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin test s'est bien arrêté");
    }
}
