package levithean.leviplugin.inventory;

import levithean.api.InventoryBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;

public class CheatGUIInventory {

    private final static String epee_turfu = "&6Épée du turfu";
    private final static String baton_serenite = "&cBâton de la sérénité";
    private final static String nom_inventaire = "&aMon menu cheat";

    public static Inventory getInventory() {

        InventoryBuilder inventory = new InventoryBuilder(nom_inventaire, 1);

        inventory.setItem(epee_turfu, Material.DIAMOND_SWORD, 1, 0, Enchantment.DAMAGE_ALL, "", "&fL'épée la &bplus cheat", "&fde tous les temps");
        inventory.setItem(baton_serenite, Material.STICK, 1, 1, "", "&fBâton qui permet", "&fde &bs'entretuer");

        return inventory.getInventory();
    }

    public static String getEpee_turfu() {
        return epee_turfu.replace('&', '§');
    }

    public static String getBaton_serenite() {
        return baton_serenite.replace('&', '§');
    }

    public static String getInventoryName() {
        return nom_inventaire.replace('&', '§');
    }

}
