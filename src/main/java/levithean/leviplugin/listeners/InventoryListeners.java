package levithean.leviplugin.listeners;

import levithean.api.ItemBuilder;
import levithean.leviplugin.inventory.CheatGUIInventory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class InventoryListeners implements Listener {

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {

        Player p = (Player)e.getWhoClicked();
        InventoryView inventory = e.getView();
        ItemStack item = e.getCurrentItem();

        if(item != null) {

            String nom_inventaire_cheatgui = CheatGUIInventory.getInventoryName();
            String nom_epee_turfu = CheatGUIInventory.getEpee_turfu();
            String nom_baton_serenite = CheatGUIInventory.getBaton_serenite();

            if(inventory.getTitle().equalsIgnoreCase(nom_inventaire_cheatgui)) {

                if(item.getItemMeta().getDisplayName().equalsIgnoreCase(nom_epee_turfu)) {

                    ItemBuilder epee = new ItemBuilder(Material.DIAMOND_SWORD, 1);

                    p.closeInventory();
                    epee.addItem(p, nom_epee_turfu, Enchantment.KNOCKBACK, 255, false, "", "&fL'épée la &bplus cheat", "&fde tous les temps");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBravo tu as trouvé l'épée !"));
                }

                if(item.getItemMeta().getDisplayName().equalsIgnoreCase(nom_baton_serenite)) {

                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cErreur: Tu n'as pas trouvé l'épée !"));
                }
            }
        }
    }
}
