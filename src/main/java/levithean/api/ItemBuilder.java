package levithean.api;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.bukkit.Bukkit.getServer;

public class ItemBuilder {

    private final ItemStack item;
    private ItemMeta item_meta;
    private List<String> lore_colore;

    public ItemBuilder(Material materiel, int quantite) {

        item = new ItemStack(materiel, quantite);
    }

    public void addItem(Player player, String nom, boolean attributs, String... lore) {

        item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

        lore_colore = Arrays.stream(lore)
                .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                .collect(Collectors.toList());

        if(!attributs)
            item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item_meta.setLore(lore_colore);

        item.setItemMeta(item_meta);
        player.getInventory().addItem(item);

    }

    public void addItem(Player player, String nom, Enchantment enchantement, int level, boolean attributs, String... lore) {

        item_meta = item.getItemMeta();

        item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

        lore_colore = Arrays.stream(lore)
                .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                .collect(Collectors.toList());

        item_meta.addEnchant(enchantement, level, true);

        if (!attributs)
            item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

        item_meta.setLore(lore_colore);

        item.setItemMeta(item_meta);
        player.getInventory().addItem(item);
    }

    public void setItem(Player player, String nom, boolean attributs, int slot, String... lore) {

        if(slot <= player.getInventory().getSize()) {

            item_meta = item.getItemMeta();

            item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

            lore_colore = Arrays.stream(lore)
                    .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                    .collect(Collectors.toList());

            if(!attributs)
                item_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            item_meta.setLore(lore_colore);

            item.setItemMeta(item_meta);
            player.getInventory().setItem(slot, item);

        } else
            getServer().getLogger().info("Impossible de creer l'inventaire");
    }

    public void setItem(Player player, String nom, Enchantment enchantment, int level, boolean attributs, int slot, String... lore) {

        if(slot <= player.getInventory().getSize()) {

            item_meta = item.getItemMeta();

            item_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', nom));

            lore_colore = Arrays.stream(lore)
                    .map(line -> ChatColor.translateAlternateColorCodes('&', line))
                    .collect(Collectors.toList());

            item_meta.addEnchant(enchantment, level, true);

            if(!attributs)
                item_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);

            item_meta.setLore(lore_colore);

            item.setItemMeta(item_meta);
            player.getInventory().setItem(slot, item);

        } else
            getServer().getLogger().info("Impossible de creer l'inventaire");
    }

}
