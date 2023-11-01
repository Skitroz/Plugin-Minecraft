package fr.skitroz.test;

import fr.skitroz.test.cmd.RdCMD;
import fr.skitroz.test.cmd.TestCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main INSTANCE;
    @Override
    public void onEnable() {
        Main.INSTANCE = this;
        System.out.println("Le plugin test s'est bien démarré");
        this.getCommand("test").setExecutor(new TestCMD());
        this.getCommand("rd").setExecutor(new RdCMD());
    }

    @Override
    public void onDisable() {
        System.out.println("Le plugin test s'est bien arrêté");
    }
}
