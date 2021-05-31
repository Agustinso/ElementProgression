package io.github.agustinso.elementprogression;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.agustinso.elementprogression.command.Elemento;
import io.github.agustinso.elementprogression.command.Frag;
import io.github.agustinso.elementprogression.command.EPConsola;
import io.github.agustinso.elementprogression.command.Sacarboard;
import io.github.agustinso.elementprogression.event.EntityDeath;

import java.io.File;

public class ElementProgression extends JavaPlugin
{
    public static Plugin plugin;
    public ElementProgression()
    {
        //
    }
    public void onEnable()
    {
        plugin = this;
        this.createConfig();
        this.getCommand("frag").setExecutor(new Frag());
        this.getCommand("epconsola").setExecutor(new EPConsola());
        this.getCommand("elemento").setExecutor(new Elemento());
        this.getCommand("sacarboard").setExecutor(new Sacarboard());
        registerEvents(this, new EntityDeath());
        this.veganRecipes();
    }

    public void onDisable()
    {
        this.saveConfig();
        this.getLogger().info("ElementProgression desactivandose...");
        plugin = null;
    }

    private static void registerEvents(Plugin plugin, Listener... listeners)
    {
        Listener[] var2 = listeners;
        int var3 = listeners.length;

        for(int var4 = 0; var4 < var3; ++var4)
        {
            Listener listener = var2[var4];
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }

    }

    private void createConfig()
    {
        try
        {
            if (!this.getDataFolder().exists())
            {
                this.getDataFolder().mkdirs();
            }

            File file = new File(this.getDataFolder(), "config.yml");
            if (!file.exists())
            {
                this.getLogger().info(ChatColor.RED + "Config.yml no encontrado, creando...");
                this.saveDefaultConfig();
            } else
            {
                this.getLogger().info(ChatColor.GREEN + "Config.yml encontrado, cargando...");
                this.getConfig();
            }
        } catch (Exception var2)
        {
            var2.printStackTrace();
        }

    }

    private void veganRecipes()
    {
        ItemStack customLeatherItem = new ItemStack(Material.LEATHER);
        ItemStack customFeatherItem = new ItemStack(Material.FEATHER);
        ItemStack customInkItem = new ItemStack(Material.INK_SAC);
        ItemStack customPieItem = new ItemStack(Material.PUMPKIN_PIE);
        ItemMeta customLeatherMeta = customLeatherItem.getItemMeta();
        ItemMeta customFeatherMeta = customFeatherItem.getItemMeta();
        customLeatherMeta.setDisplayName("EcoCuero");
        customFeatherMeta.setDisplayName("Pluma de papel");
        customLeatherItem.setItemMeta(customLeatherMeta);
        customFeatherItem.setItemMeta(customFeatherMeta);
        NamespacedKey customLeatherkey = new NamespacedKey(this, "ecocuero");
        FurnaceRecipe customLeatherRecipe = new FurnaceRecipe(customLeatherkey, customLeatherItem, Material.ROTTEN_FLESH, 0.35F, 600);
        NamespacedKey customFeatherkey = new NamespacedKey(this, "ecopluma");
        ShapelessRecipe customFeatherRecipe = new ShapelessRecipe(customFeatherkey, customFeatherItem);
        NamespacedKey customInkkey = new NamespacedKey(this, "ecotinta");
        ShapelessRecipe customInkRecipe = new ShapelessRecipe(customInkkey, customInkItem);
        NamespacedKey customPiekey = new NamespacedKey(this, "ecotarta");
        ShapelessRecipe customPieRecipe = new ShapelessRecipe(customPiekey, customPieItem);
        customFeatherRecipe.addIngredient(6, Material.PAPER);
        customFeatherRecipe.addIngredient(3, Material.STICK);
        customInkRecipe.addIngredient(1, Material.COAL);
        customPieRecipe.addIngredient(1, Material.PUMPKIN);
        customPieRecipe.addIngredient(3, Material.KELP);
        customPieRecipe.addIngredient(1, Material.SUGAR);
        boolean boolLeatherRecipe = this.getServer().addRecipe(customLeatherRecipe);
        if (boolLeatherRecipe)
        {
            this.getLogger().info("boolLeatherRecipe");
        }

        boolean boolFeatherRecipe = this.getServer().addRecipe(customFeatherRecipe);
        if (boolFeatherRecipe)
        {
            this.getLogger().info("boolFeatherRecipe");
        }

        boolean boolInkRecipe = this.getServer().addRecipe(customInkRecipe);
        if (boolInkRecipe)
        {
            this.getLogger().info("boolInkRecipe");
        }

        boolean boolPieRecipe = this.getServer().addRecipe(customPieRecipe);
        if (boolPieRecipe)
        {
            this.getLogger().info("boolPieRecipe");
        }

    }
}
