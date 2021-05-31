package io.github.agustinso.elementprogression.command;

import io.github.agustinso.elementprogression.ElementProgression;
import io.github.agustinso.elementprogression.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Date;

public class Frag implements CommandExecutor {
   private Utils utils = new Utils();

   public Frag() {
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
      if (!(sender instanceof Player))
      {
         sender.sendMessage("Comando solo para players.");
         return false;
      } else if (args.length == 0)
      {
         return false;
      } else
      {
         Player player = (Player)sender;
         if (args[0].equalsIgnoreCase("debug"))
         {
            if (ElementProgression.plugin.getConfig().isSet(player.getName() + ".debug"))
            {
               if (ElementProgression.plugin.getConfig().getBoolean(sender.getName() + ".debug"))
               {
                  sender.sendMessage(ChatColor.GREEN + "Debug desactivado.");
                  ElementProgression.plugin.getConfig().set(player.getName() + ".debug", false);
               } else
               {
                  ElementProgression.plugin.getConfig().set(player.getName() + ".debug", true);
                  sender.sendMessage(ChatColor.GREEN + "Debug activado.");
               }

               ElementProgression.plugin.saveConfig();
            } else
            {
               player.sendMessage(ChatColor.RED + "Todavia no elegiste elemento, usa :");
               player.sendMessage(ChatColor.YELLOW + "/elemento [Aire/Agua/Tierra/Fuego/Aleatorio]");
            }

            return true;
         } else if (args[0].equalsIgnoreCase("info"))
         {
            int frags = ElementProgression.plugin.getConfig().getInt(player.getName() + ".fragmentos");
            int cont = ElementProgression.plugin.getConfig().getInt(player.getName() + ".contador");
            long cd = ElementProgression.plugin.getConfig().getLong(player.getName() + ".cd");
            String cdrestante = "";
            if (Instant.now().getEpochSecond() - 3600L < cd)
            {
               long cdrestLong = cd - Instant.now().getEpochSecond();
               int cdrest = (int)cdrestLong;
               long minutesL = (cdrest / 60);
               int minutes = (int)minutesL;
               long secondsL = (cdrest % 60);
               int seconds = (int)secondsL;
               ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
               console.sendMessage("frag." + player.getName() + "." + cdrestLong + "." + cd + "." + Instant.now().getEpochSecond() + "." + minutes + "." + seconds);
               String min = (new DecimalFormat("#")).format(minutes);
               String sec = (new DecimalFormat("00")).format(seconds);
               cdrestante = min + ":" + sec;
            }

            Date cddate = new Date(cd * 1000L);
            String cdstring;
            if (this.utils.checkCd(player))
            {
               cdstring = "{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\"¡Ya disponible!\",\"bold\":true,\"color\":\"gold\"}";
            } else
            {
               cdstring = "{\"text\":\"" + cdrestante + "\",\"italic\":true,\"color\":\"red\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[\"\",{\"text\":\"Ultimo conseguido el: \",\"bold\":true,\"italic\":true},{\"text\":\"" + cddate + "\",\"italic\":true,\"color\":\"dark_aqua\"}]}}";
            }

            String tellraw = "[\"\",{\"text\":\"⬡ ────── \",\"color\":\"yellow\"},{\"text\":\"Frag Info\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\" ───────\\n▷ \",\"color\":\"yellow\"},{\"text\":\"Fragmentos:\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\" \",\"color\":\"yellow\"},{\"text\":\"" + frags + "\",\"color\":\"blue\"},{\"text\":\"\\n\"},{\"text\":\"▷ \",\"color\":\"yellow\"},{\"text\":\"Tiempo para el siguiente:\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\" \",\"color\":\"yellow\"}," + cdstring + ",{\"text\":\"\\n\"},{\"text\":\"▷ Contador: \",\"color\":\"yellow\"},{\"text\":\"" + cont + "\",\"color\":\"blue\"},{\"text\":\"\\n\"},{\"text\":\"⬡ ───────── \",\"color\":\"yellow\"},{\"text\":\"k\",\"obfuscated\":true,\"color\":\"dark_blue\"},{\"text\":\" \",\"color\":\"dark_blue\"},{\"text\":\"──────────\",\"color\":\"yellow\"}]";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + player.getName() + " " + tellraw);
            return true;
         } else
         {
            return false;
         }
      }
   }
}
