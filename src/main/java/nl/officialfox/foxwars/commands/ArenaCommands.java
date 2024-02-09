package nl.officialfox.foxwars.commands;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import nl.officialfox.foxwars.configs.ArenaConfig;
import nl.officialfox.foxwars.game.Arena;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("arena")
public class ArenaCommands extends CommandBase {

    @Default
    public void onDefault(final CommandSender sender){
        sendHelp((Player) sender);
    }
    @SubCommand("setlobby")
    public void setLobbyCommand(final CommandSender sender){

    }
    @SubCommand("removelobby")
    public void removeLobbyCommand(final CommandSender sender){

    }
//   /arena setlobby

    private void sendHelp(Player player){
        player.sendMessage("/arena setlobby");
        player.sendMessage("/arena setspawn [arenaID]");
        player.sendMessage("/arena removelobby");
    }

}
