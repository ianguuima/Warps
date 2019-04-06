package me.warp.utils;

import me.warp.entidades.objetos.PlayerWarp;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static me.warp.WarpMain.getInstance;
import static me.warp.WarpMain.getPlayerManager;

public class Tasker {


    public static void start(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), () -> {

            List<PlayerWarp> teletransportando = getPlayerManager().getPlayerManagerList().stream()
                    .filter(PlayerWarp::isTeletransportando).collect(Collectors.toList());

            for (PlayerWarp playerWarp : teletransportando){


                long valor = playerWarp.getCurrentTime() + TimeUnit.SECONDS.toMillis(playerWarp.getWarp().getDelay());


                if (System.currentTimeMillis() >= valor){
                    Player p = Bukkit.getPlayer(playerWarp.getPlayer());
                    p.teleport(playerWarp.getWarp().getLocation());
                    p.sendMessage("Teletransportado com sucesso!");
                    playerWarp.setTeletransportando(false);
                }


            }


        }, 0, 20);
    }


}
