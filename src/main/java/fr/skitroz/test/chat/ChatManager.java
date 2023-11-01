package fr.skitroz.test.chat;

import org.bukkit.ChatColor;

public class ChatManager {
    public enum MessageType
    {
        CLASSIC("CLASSIC", ChatColor.GRAY + "[" + ChatColor.GOLD + "Niflheim" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
        RIGHT("RIGHT", ChatColor.GRAY + "[" + ChatColor.GREEN + "Niflheim" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
        ERROR("ERROR", ChatColor.GRAY + "[" + ChatColor.RED + "Niflheim" + ChatColor.GRAY + "]" + ChatColor.WHITE + " > " + ChatColor.GRAY),
        UNKNOWCOMMAND("UNKNOWCOMMAND", "Unknown command. Type \"/help\" for help.");

        private String type;

        private MessageType(final String name, final String type) {
            this.type = type;
        }

        public String getMessage() {
            return this.type;
        }
    }

}
