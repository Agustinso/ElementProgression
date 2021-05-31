package io.github.agustinso.elementprogression.command;

import io.github.agustinso.elementprogression.Utils;
import io.github.agustinso.elementprogression.ElementProgression;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Elemento implements CommandExecutor
{
   private Utils utils = new Utils();

   public Elemento()
   {
      //
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
      if (!(sender instanceof Player))
      {
         sender.sendMessage("Comando solo para players.");
         return true;
      } else if (ElementProgression.plugin.getConfig().isSet(sender.getName() + ".elemento") && !ElementProgression.plugin.getConfig().getString(sender.getName() + ".elemento").equalsIgnoreCase("nada"))
      {
         sender.sendMessage(ChatColor.RED + "Ya manejas un elemento");
         return true;
      } else if (args.length == 0)
      {
         return false;
      } else if (args[0].equalsIgnoreCase("aire"))
      {
         ElementProgression.plugin.getConfig().createSection(sender.getName());
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose.air");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla choose air");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla preset create vacio");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose.air");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " group set " + args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".elemento", args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".debug", false);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".cd", Instant.now().getEpochSecond() - 3600L);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".contador", 0);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".fragmentos", 0);
         ElementProgression.plugin.saveConfig();
         return true;
      } else if (args[0].equalsIgnoreCase("agua"))
      {
         ElementProgression.plugin.getConfig().createSection(sender.getName());
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose.water");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla choose water");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla preset create vacio");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose.water");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " group set " + args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".elemento", args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".debug", false);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".cd", Instant.now().getEpochSecond() - 3600L);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".contador", 0);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".fragmentos", 0);
         ElementProgression.plugin.saveConfig();
         return true;
      } else if (args[0].equalsIgnoreCase("tierra"))
      {
         ElementProgression.plugin.getConfig().createSection(sender.getName());
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose.earth");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla choose earth");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla preset create vacio");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose.earth");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " group set " + args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".elemento", args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".debug", false);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".cd", Instant.now().getEpochSecond() - 3600L);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".contador", 0);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".fragmentos", 0);
         ElementProgression.plugin.saveConfig();
         return true;
      } else if (args[0].equalsIgnoreCase("fuego"))
      {
         ElementProgression.plugin.getConfig().createSection(sender.getName());
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose.fire");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla choose fire");
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla preset create vacio");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose.fire");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " group set " + args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".elemento", args[0].toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".debug", false);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".cd", Instant.now().getEpochSecond() - 3600L);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".contador", 0);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".fragmentos", 0);
         ElementProgression.plugin.saveConfig();
         return true;
      } else if (args[0].equalsIgnoreCase("aleatorio"))
      {
         ElementProgression.plugin.getConfig().createSection(sender.getName());
         int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
         String randomElem = "";
         String elemIngles = "";
         switch(randomNum) {
         case 1:
            randomElem = "aire";
            elemIngles = "air";
            break;
         case 2:
            randomElem = "agua";
            elemIngles = "water";
            break;
         case 3:
            randomElem = "tierra";
            elemIngles = "earth";
            break;
         case 4:
            randomElem = "fuego";
            elemIngles = "fire";
         }

         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " add atla.command.choose." + elemIngles);
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla choose " + elemIngles);
         ElementProgression.plugin.getServer().dispatchCommand(sender, "atla preset create vacio");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose." + elemIngles);
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " remove atla.command.choose");
         ElementProgression.plugin.getServer().dispatchCommand(ElementProgression.plugin.getServer().getConsoleSender(), "pex user " + sender.getName() + " group set " + randomElem.toLowerCase());
         ElementProgression.plugin.getConfig().set(sender.getName() + ".elemento", randomElem);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".debug", false);
         Player player = (Player)sender;
         this.utils.setCd(player);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".contador", 0);
         ElementProgression.plugin.getConfig().set(sender.getName() + ".fragmentos", 0);
         ElementProgression.plugin.saveConfig();
         return true;
      } else
      {
         return false;
      }
   }
}
