package levithean.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.bukkit.Bukkit.getServer;

public class InventoryBuilder {

    private final Inventory inventory;
    private ItemStack item;
    private ItemMeta item_meta;
    private List<String> lore_colore;

    public InventoryBuilder(String titre, int rows) {

        inventory = Bukkit.createInventory(null, rows * 9, ChatColor.translateAlternateColorCodes('&', titre));
    }

    public void setItem(String nom, Material materiel, int quantite, int slot, String... lore) {

        if(slot <= inventory.getSize()) {

            item = new ItemStack(materiel, quantite);
            item_meta = item.getItemMeta();

            item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

            lore_colore = Arrays.stream(lore)
                    .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                    .collect(Collectors.toList());

            item_meta.setLore(lore_colore);
            item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            item.setItemMeta(item_meta);
            inventory.setItem(slot, item);

        } else
            getServer().getLogger().info("Impossible de creer l'inventaire");

    }

    public void setItem(String nom, Material materiel, int quantite, int slot, Enchantment enchantement, String... lore) {

        if(slot <= inventory.getSize()) {

            item = new ItemStack(materiel, quantite);
            item_meta = item.getItemMeta();

            item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

            lore_colore = Arrays.stream(lore)
                    .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                    .collect(Collectors.toList());

            item_meta.setLore(lore_colore);
            item_meta.addEnchant(enchantement, 255, true);
            item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

            item.setItemMeta(item_meta);
            inventory.setItem(slot, item);

        } else
            getServer().getLogger().info("Impossible de creer l'inventaire");
    }

    public Inventory getInventory() {
        return inventory;
    }
}
