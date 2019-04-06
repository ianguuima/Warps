package me.warp.comandos;

import me.warp.entidades.objetos.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static me.warp.WarpMain.*;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("warp")){

            if (args.length == 0){
                p.sendMessage(" ");
                p.sendMessage("§c/warp <nome> §8- §7vá até uma warp!");
                p.sendMessage("§c/warp set <nome> §8- §7seta uma warp!");
                p.sendMessage("§c/warp deletar <nome> §8- §7deleta uma warp!");
                p.sendMessage(" ");
            }

            if (args.length == 1){
                String warpDesejada = args[0];
                if (getWarpManager().getWarp(warpDesejada) == null){
                    p.sendMessage("§7Warp não existe!");
                    return false;
                }

                getWarpManager().teletransportarWarp(p, warpDesejada);
            }

            if (args.length == 2){
                if (args[0].equalsIgnoreCase("set")){

                    // O jogador está digitando o /warp set <nome>
                    String warpDesejada = args[1];
                    if (!getWarpManager().warpExists(p, warpDesejada)) return false;


                    getWarpManager().createWarp(new Warp(warpDesejada, p.getLocation(), 5));
                    p.sendMessage("§7A warp foi criada com sucesso!");

                }

                if (args[0].equalsIgnoreCase("deletar")){

                    String warpDesejada = args[1];
                    if (!getWarpManager().warpExists(p, warpDesejada)) return false;

                    getWarpManager().deleteWarp(warpDesejada);
                    p.sendMessage("§7A warp foi deletada com sucesso!");



                }
            }


        }


        return false;
    }
}
