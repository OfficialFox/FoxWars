package nl.officialfox.foxwars.commands;

import nl.officialfox.foxwars.configs.ArenaConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LobbyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(label.equalsIgnoreCase("lobby")){
                if(args.length < 1){
                    sendHelp(player);
                    return true;
                }
                if(args[0].equalsIgnoreCase("setspawn")){
                    ArenaConfig.saveLobbyLocation(player.getLocation());
                } else if(args[0].equalsIgnoreCase("test")){
                    if(ArenaConfig.getLobbyLocation() != null) {
                        player.teleport(ArenaConfig.getLobbyLocation());
                    }
                }
            }


        }
        return false;
    }


    private void sendHelp(Player player){
        player.sendMessage("/lobby setspawn");
    }
}
