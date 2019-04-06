package me.warp.entidades.manager;

import me.warp.entidades.objetos.PlayerWarp;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<PlayerWarp> playerManagerList;

    public PlayerManager() {
        playerManagerList = new ArrayList<>();
        loadPlayers();
    }

    public void createPlayer(PlayerWarp playerManager){
        playerManagerList.add(playerManager);
    }

    public PlayerWarp getPlayer(String nome){
        for (PlayerWarp playerManager : playerManagerList){
            if (playerManager.getPlayer().equalsIgnoreCase(nome)) return playerManager;
        }
        return null;
    }

    private void loadPlayers(){
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            createPlayer(new PlayerWarp(onlinePlayer.getName()));
        }
    }

    public List<PlayerWarp> getPlayerManagerList() {
        return playerManagerList;
    }
}
