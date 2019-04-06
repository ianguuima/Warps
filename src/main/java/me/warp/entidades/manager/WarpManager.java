package me.warp.entidades.manager;

import me.warp.entidades.objetos.PlayerWarp;
import me.warp.entidades.objetos.Warp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static me.warp.WarpMain.*;

public class WarpManager {

    private List<Warp> warpList;

    public WarpManager() {
        warpList = new ArrayList<>();
        loadWarps();
    }


    public Warp getWarp(String name){
        for (Warp warp : warpList){
            if (warp.getNome().equalsIgnoreCase(name)) return warp;
        }

        return null;
    }

    public void teletransportarWarp(Player p, String nome){
        Warp warp = getWarp(nome);
        PlayerWarp playerManager = getPlayerManager().getPlayer(p.getName());
        playerManager.setCurrentTime(System.currentTimeMillis());
        playerManager.setTeletransportando(true);
        playerManager.setWarp(warp);
    }

    public boolean warpExists(Player p, String nome){
        if (getWarpManager().getWarp(nome) == null){
            p.sendMessage("§7Warp não existe!");
            return false;
        }
        return true;
    }

    public void createWarp(Warp warp){
        warpList.add(warp);
        ConfigurationSection warps = getInstance().getConfig().getConfigurationSection("Warps");

        warps.set(warp.getNome() + ".delay", warp.getDelay());
        warps.set(warp.getNome() + ".world" , warp.getLocation().getWorld().getName());
        warps.set(warp.getNome() + ".x", warp.getLocation().getX());
        warps.set(warp.getNome() + ".y", warp.getLocation().getY());
        warps.set(warp.getNome() + ".z", warp.getLocation().getZ());
        warps.set(warp.getNome() + ".yaw", warp.getLocation().getYaw());
        warps.set(warp.getNome() + ".pitch", warp.getLocation().getPitch());

        getInstance().saveConfig();
    }

    public void deleteWarp(String nome){
        Warp warp = getWarp(nome);
        ConfigurationSection warps = getInstance().getConfig().getConfigurationSection("Warps");
        warps.set(warp.getNome(), null);
        getInstance().saveConfig();
        warpList.remove(warp);
    }

    private void loadWarps(){
        ConfigurationSection warps = getInstance().getConfig().getConfigurationSection("Warps");

        for (String warp : warps.getKeys(false)){

            int delay = warps.getInt(warp + ".delay");
            World world = Bukkit.getWorld(warps.getString(warp + ".world"));
            double x = warps.getDouble(warp + ".x");
            double y = warps.getDouble(warp + ".y");
            double z = warps.getDouble(warp + ".z");
            float yaw = warps.getLong(warp + ".yaw");
            float pitch = warps.getLong(warp + ".pitch");
            Location location = new Location(world, x, y, z, yaw, pitch);

            warpList.add(new Warp(warp, location, delay));
        }

        Bukkit.getConsoleSender().sendMessage("§aSUCESSO §8>> §7As warps foram carregadas §acom suceso§7. Um total de §a" + warpList.size() + "§7!");
    }




    public List<Warp> getWarpList() {
        return warpList;
    }
}
