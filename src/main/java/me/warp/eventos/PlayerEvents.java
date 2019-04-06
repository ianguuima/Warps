package me.warp.eventos;

import me.warp.entidades.objetos.PlayerWarp;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static me.warp.WarpMain.*;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        String playerName = e.getPlayer().getName();

        if (getPlayerManager().getPlayer(playerName) != null) return;

        getPlayerManager().createPlayer(new PlayerWarp(playerName));
    }

}
