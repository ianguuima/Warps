package me.warp;

import me.warp.comandos.WarpCommand;
import me.warp.entidades.manager.PlayerManager;
import me.warp.entidades.manager.WarpManager;
import me.warp.eventos.PlayerEvents;
import me.warp.utils.Tasker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpMain extends JavaPlugin {

    private static WarpMain instance;
    private static WarpManager warpManager;
    private static PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();


        // MANAGERS

        warpManager = new WarpManager();
        playerManager = new PlayerManager();



        // COMANDOS
        loadComandosEventos();


        Tasker.start();

    }

    private void loadConfiguration(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    private void loadComandosEventos(){
        // EVENTOS
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);


       getCommand("warp").setExecutor(new WarpCommand());
    }



    public static WarpMain getInstance() {
        return instance;
    }

    public static WarpManager getWarpManager() {
        return warpManager;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
}
