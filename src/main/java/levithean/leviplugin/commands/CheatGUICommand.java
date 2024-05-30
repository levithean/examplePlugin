package levithean.leviplugin.commands;

import levithean.leviplugin.inventory.CheatGUIInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheatGUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("cheatgui")) {

            if(sender instanceof Player) {

                Player p = (Player)sender;

                p.openInventory(CheatGUIInventory.getInventory());
            }
        }

        return true;
    }
}
