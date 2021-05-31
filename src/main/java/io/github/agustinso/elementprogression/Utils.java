package io.github.agustinso.elementprogression;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
   public Utils() {
   }

   public void giveFrag(Player player) {
      this.sendDebug(player, "giveFrag()");
      this.sendDebug(player, "Seteando contador en 0...");
      ElementProgression.plugin.getConfig().set(player.getName() + ".contador", 0);
      player.sendTitle(ChatColor.AQUA + "" + ChatColor.MAGIC + "k", "¡Fragmento conseguido!", 20, 40, 40);
      this.setCd(player);
      if (ElementProgression.plugin.getConfig().getInt(player.getName() + ".fragmentos") < 2) {
         ElementProgression.plugin.getConfig().set(player.getName() + ".fragmentos", ElementProgression.plugin.getConfig().getInt(player.getName() + ".fragmentos") + 1);
         this.sendDebug(player, "Fragmentos: " + ElementProgression.plugin.getConfig().getString(player.getName() + ".fragmentos"));
      } else {
         this.sendDebug(player, "3 fragmentos, seteando en 0 y giveMove()...");
         ElementProgression.plugin.getConfig().set(player.getName() + ".fragmentos", 0);
         this.giveMove(player);
      }

      ElementProgression.plugin.saveConfig();
   }

   public void giveMove(Player player) {
      this.sendDebug(player, "giveMove()");
      String elem = ElementProgression.plugin.getConfig().getString(player.getName() + ".elemento");
      List<String> perms = ElementProgression.plugin.getConfig().getStringList(elem);
      boolean keep = true;
      int safe = 0;

      while(keep) {
         ++safe;
         int randomNum = ThreadLocalRandom.current().nextInt(0, perms.size());
         this.sendDebug(player, "RNG: " + randomNum);
         if (!player.hasPermission(perms.get(randomNum))) {
            this.sendDebug(player, "(String) perms.get(randomNum) : " + perms.get(randomNum));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add " + perms.get(randomNum));
            keep = false;
         }

         if (safe == 1000) {
            keep = false;
            ElementProgression.plugin.getLogger().info(ChatColor.RED + "giveMove() 1000 iteraciones, player: " + player.getName());
         }
      }

      player.sendTitle(ChatColor.GOLD + "¡Nueva habilidad conseguida!", ChatColor.MAGIC + "" + ChatColor.BLUE + "k", 20, 40, 40);
      ElementProgression.plugin.saveConfig();
   }

   public void setCd(Player player) {
      ElementProgression.plugin.getConfig().set(player.getName() + ".cd", Instant.now().getEpochSecond() + 3600L);
      ElementProgression.plugin.saveConfig();
   }

   public boolean checkCd(Player player) {
      if (!ElementProgression.plugin.getConfig().isSet(player.getName() + ".cd")) {
         ElementProgression.plugin.getLogger().info("error en checkcd(), cd no seteado. Player: " + player.getName());
         return false;
      } else {
         return ElementProgression.plugin.getConfig().getLong(player.getName() + ".cd") <= Instant.now().getEpochSecond();
      }
   }

   public void sendDebug(Player player, String msg) {
      if (ElementProgression.plugin.getConfig().isSet(player.getName() + ".debug") && ElementProgression.plugin.getConfig().getBoolean(player.getName() + ".debug")) {
         player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "[DEBUG] " + msg);
      }

   }
}
