package io.github.agustinso.elementprogression.command;

import io.github.agustinso.elementprogression.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

public class Sacarboard implements CommandExecutor {
   private Utils utils = new Utils();

   public Sacarboard()
   {
      //
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
   {
      if (!(sender instanceof Player))
      {
         sender.sendMessage("Comando solo para player.");
         return true;
      } else
      {
         Player player = (Player)sender;
         ScoreboardManager sm = Bukkit.getServer().getScoreboardManager();
         player.setScoreboard(sm.getNewScoreboard());
         return true;
      }
   }
}
