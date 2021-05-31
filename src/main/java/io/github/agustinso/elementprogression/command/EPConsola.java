package io.github.agustinso.elementprogression.command;

import io.github.agustinso.elementprogression.ElementProgression;
import io.github.agustinso.elementprogression.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EPConsola implements CommandExecutor
{
   private Utils utils = new Utils();

   public EPConsola()
   {
      //
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
      if (sender instanceof Player)
      {
         sender.sendMessage("Comando solo para consola.");
         return true;
      } else if (args.length < 2)
      {
         return false;
      } else
      {
         Player player = ElementProgression.plugin.getServer().getPlayer(args[1]);
         if (player == null)
         {
            sender.sendMessage("Player desconectado/incorrecto.");
            return true;
         } else if (args[0].equalsIgnoreCase("darfrag"))
         {
            this.utils.giveFrag(player);
            sender.sendMessage("Todo Ok.");
            return true;
         } else if (args[0].equalsIgnoreCase("darhab"))
         {
            this.utils.giveMove(player);
            sender.sendMessage("Todo Ok.");
            return true;
         } else
         {
            return false;
         }
      }
   }
}
