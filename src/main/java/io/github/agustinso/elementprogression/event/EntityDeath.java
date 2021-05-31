package io.github.agustinso.elementprogression.event;

import io.github.agustinso.elementprogression.ElementProgression;
import io.github.agustinso.elementprogression.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class EntityDeath implements Listener
{
   private Utils utils = new Utils();

   public EntityDeath()
   {
      //
   }

   @EventHandler
   public void onEntityDeath(EntityDeathEvent event)
   {
      if (event.getEntity().getKiller() != null && event.getEntity().getKiller() instanceof Player)
      {
         Player player = event.getEntity().getKiller();
         if (ElementProgression.plugin.getConfig().getString(player.getName() + ".elemento").equalsIgnoreCase("nada"))
         {
            player.sendMessage(ChatColor.RED + "Todavia no elegiste elemento, usa :");
            player.sendMessage(ChatColor.YELLOW + "/elemento [Aire/Agua/Tierra/Fuego/Aleatorio]");
         } else
         {
            if (event.getEntity() instanceof Monster)
            {
               if (event.getEntity().getKiller().getWorld().getEnvironment().toString().equalsIgnoreCase("THE_END"))
               {
                  if (event.getEntity() instanceof Enderman)
                  {
                     return;
                  }

                  if (event.getEntity() instanceof EnderDragon)
                  {
                     Iterator var3 = Bukkit.getOnlinePlayers().iterator();

                     while(var3.hasNext())
                     {
                        Player ploop = (Player)var3.next();
                        this.utils.giveFrag(ploop);
                     }
                  }
               }

               this.utils.sendDebug(player, "Mob valido.");
               ElementProgression.plugin.getConfig().set(player.getName() + ".contador", ElementProgression.plugin.getConfig().getInt(player.getName() + ".contador") + 1);
               this.utils.sendDebug(player, "Contador : " + ElementProgression.plugin.getConfig().getString(player.getName() + ".contador"));
               int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
               this.utils.sendDebug(player, "RNG: " + String.valueOf(randomNum) + ".");
               if (randomNum == 0) {
                  this.utils.sendDebug(player, "Chance valida, mirando cd...");
                  if (this.utils.checkCd(player)) {
                     this.utils.sendDebug(player, "CD listo, giveFrag()...");
                     this.utils.giveFrag(player);
                  } else
                  {
                     this.utils.sendDebug(player, "En cd.");
                  }
               }
            }

         }
      }
   }
}
