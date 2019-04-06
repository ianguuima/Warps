package me.warp;

import me.warp.comandos.WarpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpMain extends JavaPlugin {

    private static WarpMain instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();




        // COMANDOS
        loadComandosEventos();

    }

    private void loadConfiguration(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    private void loadComandosEventos(){
        getCommand("warps").setExecutor(new WarpCommand());
    }



    public static WarpMain getInstance() {
        return instance;
    }
}
